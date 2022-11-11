from tree_sitter import Language, Parser
import os
import copy
import shutil
from pathlib import Path
root = './model_predictions/'


# prepare tree-sitter parser
Language.build_library(
    'build/my-java.so',
    ['vendor/tree-sitter-java']
)

JAVA_LANGUAGE = Language('build/my-java.so', 'java')

JAVA_PATTERNS = {
    'METHOD_SIGNATURE': '''
    (method_declaration
        (modifiers) @mod
        type: (void_type) @void
        name: (identifier) @name
        parameters:
            (formal_parameters
                (formal_parameter
                (modifiers)
                type: (type_identifier)
                name: (identifier))
                (formal_parameter
                (modifiers)
                type: (type_identifier)
                name: (identifier))
            ) @param
    ) ''',

    'METHOD_BODY': '''
    (method_declaration
        body: (block) @body
    )
    ''',

    'MARKER_ANNOTATION': '''
    (method_declaration
        (modifiers
            (marker_annotation name: (identifier) @marker_annotation)
        )
    )''',

    'ANNOTATION': '''
    (method_declaration
        (modifiers
            (annotation name: (identifier) @annotation)
        )
    )''',
}

parser = Parser()
parser.set_language(JAVA_LANGUAGE)


# getting the blob from the parse tree
def get_blob(code, node):
    return code[node.start_byte:node.end_byte]


# parse the original file and remove method with '@Test'
def rm_orig_tests(code):
    tree = parser.parse(bytes(code, 'utf8'))
    root_node = tree.root_node
    mark_ann_query = JAVA_LANGUAGE.query(JAVA_PATTERNS['MARKER_ANNOTATION'])
    mark_ann_captures = mark_ann_query.captures(root_node)
    ann_query = JAVA_LANGUAGE.query(JAVA_PATTERNS['ANNOTATION'])
    ann_captures = ann_query.captures(root_node)
    test_annotated = []

    for cp in mark_ann_captures:
        if get_blob(code, cp[0]) == 'Test':
            test_annotated.append(cp[0].parent.parent.parent)
    for cp in ann_captures:
        if get_blob(code, cp[0]) == 'Test':
            test_annotated.append(cp[0].parent.parent.parent)

    after_rm = code
    for test_ann in sorted(test_annotated):
        test = get_blob(code, test_ann)
        after_rm = after_rm.replace(test, '')

    inject_point = test_annotated[0].start_point[0]
    after_rm = after_rm.splitlines()

    return after_rm, inject_point


def get_tc_lists(gen_test_path, after_rm, inject_point, curdir, file):
    # read the file with the generated tc to a list.
    with open(gen_test_path, 'r') as test_f:
        test_code = test_f.read()
        test_code_lists = test_code.split('@Test')

    # remove empty lines
    for line in test_code_lists:
        if not line:
            test_code_lists.remove(line)

    # add the '@Test' token to te tc list
    for i in range(len(test_code_lists)):
        test_code_lists[i] = test_code_lists[i].strip()
        if test_code_lists[i].startswith('('):
            test_code_lists[i] = '@Test' + test_code_lists[i]
        else:
            test_code_lists[i] = '@Test\n' + test_code_lists[i]

    # check every TCs if they are sytactically correct
    correct_tcs = []
    for i, test_code in enumerate(test_code_lists):
        # if i != 14:
        #     continue
        temp = copy.deepcopy(after_rm)
        temp.insert(inject_point, test_code)
        full_code = '\n'.join(temp)
        tree = parser.parse(bytes(full_code, 'utf8'))
        root_node = tree.root_node
        # print(root_node.sexp())
        if 'ERROR' in root_node.sexp() or 'MISSING' in root_node.sexp():
            os.makedirs(f'out/errors/{curdir}/', exist_ok=True)
            with open(f'out/errors/{curdir}/{file}_{i}.java', 'w') as error_f:
                error_f.write(test_code)
        else:
            correct_tcs.append(test_code)

    return correct_tcs


# function that deletes original tests from defects4j project and
# replaces with the ones that are generated from the deep learning model
def replace_tests():
    # traverses the defects4j file
    for curdir, _, files in sorted(os.walk('lang3')):
        # iterate java files
        for file in sorted(files):
            if file.endswith('.java'):
                gen_test_path = os.path.join(
                    'out/runnable_tests', curdir, file)
                cur_file_path = os.path.join(curdir, file)
                print(cur_file_path)

                # read the original defects4j file
                with open(cur_file_path, 'r') as read_f:
                    code = read_f.read()

                # check if there is a corresponding file that has the generated tc
                if not Path(gen_test_path).is_file():
                    # print(gen_test_path, 'does not exist')
                    continue

                # remove methods with '@Test'
                after_rm, inject_point = rm_orig_tests(code)

                # get syntactically correct tc lists from generated file
                correct_tcs = get_tc_lists(
                    gen_test_path, after_rm, inject_point, curdir, file)

                # if there are no correct_tcs skip
                if not correct_tcs:
                    continue

                after_rm.insert(inject_point, '\n'.join(correct_tcs))

                os.makedirs(f'out/combined/{curdir}/', exist_ok=True)
                with open(f'out/combined/{curdir}/{file}', 'w') as file_w:
                    for line in after_rm:
                        file_w.write(line)
                        file_w.write('\n')
        #         break
        # break


if __name__ == "__main__":
    if os.path.exists("out/errors/"):
        shutil.rmtree("out/errors/")
    if os.path.exists("out/combined/"):
        shutil.rmtree("out/combined/")
    replace_tests()

from tree_sitter import Language, Parser
import os
import copy
import shutil
from pathlib import Path



# prepare tree-sitter parser
Language.build_library(
    'build/my-java.so',
    ['vendor/tree-sitter-java']
)
JAVA_LANGUAGE = Language('build/my-java.so', 'java')
JAVA_PATTERNS = {
    'sav': '''
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
    
    'METHOD_NAME': '''
    (method_declaration
        name: (identifier) @name
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
project_name = 'Lang'
total_gen_tcs = 0
not_parsable_tcs = 0
not_compilable_tcs = 0

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
    
    # get original test, with @Test annotations
    test_annotated = []
    for cp in mark_ann_captures:
        if get_blob(code, cp[0]) == 'Test':
            test_annotated.append(cp[0].parent.parent.parent)
    for cp in ann_captures:
        if get_blob(code, cp[0]) == 'Test':
            test_annotated.append(cp[0].parent.parent.parent)

    # if nothing is annotated with @Test, check for methods with 'test'.
    if len(test_annotated) == 0:
        q = JAVA_LANGUAGE.query(JAVA_PATTERNS['METHOD_NAME'])
        c = q.captures(root_node)
        for cp in c:
            if 'test' in get_blob(code, cp[0]).lower():
                test_annotated.append(cp[0].parent)
            

    after_rm = code
    for test_ann in sorted(test_annotated):
        test = get_blob(code, test_ann)
        after_rm = after_rm.replace(test, '')

    inject_point = test_annotated[0].start_point[0]
    after_rm = after_rm.splitlines()

    return after_rm, inject_point


def get_tc_lists(gen_test_path):
    # read the file with the generated tc to a list.
    # replace this part with the new token
    with open(gen_test_path, 'r') as test_f:
        test_code = test_f.read()
    test_code_lists = test_code.split('@Test')

    # remove empty lines
    for line in test_code_lists:
        if not line:
            test_code_lists.remove(line)

    # add the '@Test' token to te tc list
    # remove if the generation does not have @Test in them
    for i in range(len(test_code_lists)):
        test_code_lists[i] = test_code_lists[i].strip()
        if test_code_lists[i].startswith('('):
            test_code_lists[i] = '@Test' + test_code_lists[i]
        else:
            test_code_lists[i] = '@Test\n' + test_code_lists[i]


    return test_code_lists


def get_correct_tcs(gen_tests, after_rm, inject_point, curdir, file):
    global total_gen_tcs
    global not_parsable_tcs
    global not_compilable_tcs

    total_gen_tcs+= len(gen_tests)
    # check every TCs if they are sytactically correct or parsable
    parsable_tcs = []
    for i, test_code in enumerate(gen_tests):
        temp = copy.deepcopy(after_rm)
        test_code = test_code.strip()
        if test_code.endswith(';'):
            test_code += '\n}\n'
        temp.insert(inject_point, test_code)
        full_code = '\n'.join(temp)
        tree = parser.parse(bytes(full_code, 'utf8'))
        root_node = tree.root_node
        if 'ERROR' in root_node.sexp() or 'MISSING' in root_node.sexp():
            # if parses fail check if rm_last_line + } helps
            full_code = full_code.strip()
            full_code = full_code[:full_code.rfind('\n')]
            full_code += '}'
            tree = parser.parse(bytes(full_code, 'utf8'))
            root_node = tree.root_node
            if 'ERROR' in root_node.sexp() or 'MISSING' in root_node.sexp():
                os.makedirs(f'out/parse_errors/{curdir}/', exist_ok=True)
                with open(f'out/parse_errors/{curdir}/{file}_{i}.java', 'w') as error_f:
                    error_f.write(test_code)
                not_parsable_tcs += 1
        else:
            parsable_tcs.append(test_code)
            
    # make new tmp dir for compilation check
    if os.path.exists('tmp/'):
        shutil.rmtree('tmp/')
    os.system(f'defects4j checkout -p {project_name} -v 1f -w tmp/defects4j_projects/{project_name}')
    # check parsable TCs if they are compilable
    compilable_tcs = []
    for i, test_code in enumerate(parsable_tcs):
        temp = copy.deepcopy(after_rm)
        temp.insert(inject_point, test_code)
        full_code = '\n'.join(temp)
        with open(f'tmp/{curdir}/{file}', 'w') as f:
            f.write(full_code)
        out = os.system(f'cd tmp/defects4j_projects/{project_name} && rm -rf target && defects4j compile')
        if out == 0:
            compilable_tcs.append(test_code)
        else:
            os.makedirs(f'out/compilation_errors/{curdir}/', exist_ok=True)
            with open(f'out/compilation_errors/{curdir}/{file}_{i}.java', 'w') as error_f:
                error_f.write(test_code)
            with open(f'tmp/{curdir}/{file}', 'w') as f:
                f.write('\n'.join(after_rm))
            not_compilable_tcs += 1
    shutil.rmtree("tmp/")

    return compilable_tcs

# defects4j checkout -p Time -v 1f -w defects4j_projects/Time
# function that deletes original tests from defects4j project
# and replaces with the ones that are generated from the model
def replace_tests(separate, project_name):

    # traverses the defects4j file
    for curdir, _, files in sorted(os.walk(f'defects4j_projects/{project_name}/src/test/java/org/apache/commons/lang3')):
        # @sepehr for full automation, need to match dir (make_test_runnable and rm_orig_tests)
        # iterate java files
        for file in sorted(files):
            # if file != 'ConversionTest.java': continue
            if file.endswith('.java'):
                dir_splt = curdir.split('lang3/')
                if len(dir_splt) > 1:
                    dr = 'lang3/' + dir_splt[1]
                else:
                    dr = 'lang3'
                gen_test_path = os.path.join('out/runnable_tests/org/apache/commons/', dr, file)
                cur_file_path = os.path.join(curdir, file)
                print(cur_file_path)

                # read the original defects4j file
                with open(cur_file_path, 'r') as read_f:
                    code = read_f.read()

                # check if there is a corresponding file that has the generated tc
                if not Path(gen_test_path).is_file():
                    print('Generated TCs for', gen_test_path, 'does not exist!!')
                    continue
                else:
                    gen_tests = get_tc_lists(gen_test_path)

                # remove methods with '@Test'
                after_rm, inject_point = rm_orig_tests(code)
                # get syntactically correct tc lists from generated file
                correct_tcs = get_correct_tcs(gen_tests, after_rm, inject_point, curdir, file)

                # if there are no correct_tcs skip
                if not correct_tcs:
                    continue

                after_rm.insert(inject_point, '\n'.join(correct_tcs))

                # for saving file separately
                if separate:
                    os.makedirs(f'out/combined/{curdir}/', exist_ok=True)
                    with open(f'out/combined/{curdir}/{file}', 'w') as file_w:
                        for line in after_rm:
                            file_w.write(line)
                            file_w.write('\n')
                else:
                    with open(cur_file_path, 'w') as file_w:
                        for line in after_rm:
                            file_w.write(line)
                            file_w.write('\n')


if __name__ == "__main__":
    if os.path.exists("out/parse_errors/"):
        shutil.rmtree("out/parse_errors/")
    if os.path.exists("out/compilation_errors/"):
        shutil.rmtree("out/compilation_errors/")
    if os.path.exists("out/combined/"):
        shutil.rmtree("out/combined/")

    # pass project name in the argument e.g. Lang
    if os.path.exists(f'defects4j_projects/{project_name}'):
        shutil.rmtree(f'defects4j_projects/{project_name}') 
    os.system(f'defects4j checkout -p {project_name} -v 1f -w defects4j_projects/{project_name}')
    replace_tests(separate=True, project_name=project_name)

    print('\ntotal generated tests:', total_gen_tcs,
          '\nnot parsable tests:', not_parsable_tcs,
          '\nnot compilable tests:', not_compilable_tcs)

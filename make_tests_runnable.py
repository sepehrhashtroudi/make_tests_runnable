import re
import os
import shutil
root = './model_predictions/'

out = "test_best-bleu.output"
info = "test_info.txt"

def prepare():

    f = open(root + "/" + out)
    out_lines = f.readlines()
    f.close()

    f = open(root + "/" + info)
    info_lines = f.readlines()
    f.close()

    global i
    i = 0

    def replace(m):
        global i
        i += 1
        test_name = m.group(0).split('(') 
        new_test_name =(str(i)+'(').join(test_name)
        return new_test_name
    
    if os.path.exists("out/"):
        shutil.rmtree("out/")

    list_of_tests = []
    for line, info_line in zip(out_lines, info_lines):
        if line not in list_of_tests:
            list_of_tests.append(line)
            line = re.sub('test\w+\(\)', replace, line)
            line = re.sub("\[EOL\]", '\n', line)
            path = info_line.split("<test_path>:")[-1].strip()
            os.makedirs(os.path.dirname("out/runnable_tests/" + path), exist_ok=True)
            with open("out/runnable_tests/" + path, "a") as Final_tests:
                Final_tests.write(line)
        

if __name__ == "__main__":
    prepare()


    

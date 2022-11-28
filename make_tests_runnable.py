import re
import os
import shutil
root = './model_predictions/'

# gold = "test_0.gold"
# out = "test_best-bleu.output"
# info = "test_info.txt"
#out = "train.tests"
#info = "train_info.txt"
# out = "test.tests"
# info = "test_info.txt"
# out = "concat.tests"
# info = "concat_info.txt"

out = "concat.tests"
info = "concat_info.txt"



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
    print(len(out_lines))
    print(len(info_lines))
    cnt = 0
    for line, info_line in zip(out_lines, info_lines):
        line = re.sub('test\w+\(\)', replace, line)
        line = re.sub("\[EOL\]", '\n', line)
        path = info_line.split("<test_path>:")[-1].strip()
        os.makedirs(os.path.dirname("out/runnable_tests/" + path), exist_ok=True)
        with open("out/runnable_tests/" + path, "a") as Final_tests:
            # print(cnt, line)
            Final_tests.write(line)
        cnt += 1
        

if __name__ == "__main__":
    prepare()


    

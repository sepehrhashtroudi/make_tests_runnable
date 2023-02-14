fist edit make_tests_runnable.py 

for DA folds:
(some of them have /prediction/ folder and some dont)

out = "./model_predictions/jxPath_test_4/prediction/test_best-bleu.output"
info = "./generated_datasets/jxPath_test_info_4.txt"

for train folds:

out = "./generated_datasets/jxPath_train_4.tests"
info = "./generated_datasets/jxPath_train_info_4.txt"

for no domain adaptation:

# out = "./model_predictions/jsoup_test_nopt_0/test_best-bleu.output"
# info = "./generated_datasets/jsoup_test_info_0.txt"

after this step, edit rm_orig_tests.py

# project_name = 'JxPath'
# test_path = 'src/test/org/apache/commons/jxpath'
# out_path = 'out/runnable_tests'
# split_length = 4

I think Ihave the config of all projects you need to uncomment it. if you didnt find it you should edit the test_path and split_length.

for train folds set "add_all_tests = 1" to 1

after generation copy the combined folder in out folder and save it for later.




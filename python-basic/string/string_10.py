import sys

test_case = int(sys.stdin.readline())

res = 0
for i in range(test_case):
    test_str = sys.stdin.readline().rstrip()
    setted_test_str = set(test_str)
    
    isValid = True
    for s in setted_test_str:
        cnt = 0
        correct = -1
        for t in test_str:
            if s != t:
                cnt += 1
            elif s == t and correct == -1:
                correct = cnt
                cnt += 1
            elif s == t and correct != -1:
                if cnt - correct != 1:
                    isValid = False
                    break
                else:
                    correct = cnt
                    cnt += 1
        if isValid == False:
            break
    if isValid == True:
        res += 1
print(res)
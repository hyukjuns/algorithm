import sys

dic = {}
for i in range(10):
    target = int(sys.stdin.readline().rstrip())
    dic[target % 42] = 1
print(len(dic))

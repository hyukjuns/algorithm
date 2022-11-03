import sys

num = int(sys.stdin.readline())
num_list = sys.stdin.readline().split()
v = int(sys.stdin.readline())

cnt = 0
for i in num_list:
    if int(i) == v:
        cnt += 1
print(cnt)
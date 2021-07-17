import sys

a = int(sys.stdin.readline().rstrip())
b = int(sys.stdin.readline().rstrip())
c = int(sys.stdin.readline().rstrip())

res = a * b * c

res = str(res)

for i in range(10):
    cnt = 0
    for t in res:
        if i == int(t):
            cnt += 1
    print(cnt)
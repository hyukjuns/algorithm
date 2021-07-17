import sys

n = int(sys.stdin.readline().rstrip())

for i in range(n):
    arr = list(sys.stdin.readline().rstrip())
    cnt=0
    sum=0
    for i in arr:
        if i == 'O':
            cnt +=1
            sum+=cnt
        else:
            cnt = 0
    print(sum)
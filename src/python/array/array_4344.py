import sys

c = int(sys.stdin.readline().rstrip())
for i in range(c):
    arr = list(map(int,sys.stdin.readline().split()))
    n = arr.pop(0)
    avg = 0.0
    for k in arr:
        avg += k
    avg = float(avg / n)
    cnt=0
    for k in arr:
        if k > avg:
            cnt += 1
    print("{res:.3f}%".format(res=float(cnt/n)*100))
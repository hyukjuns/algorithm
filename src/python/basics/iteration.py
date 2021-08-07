import sys

n, x = map(int,sys.stdin.readline().split())

arr = list(sys.stdin.readline().rstrip().split())

for t in arr:
    if int(t) < x:
        sys.stdout.write(t+" ")
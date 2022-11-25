import sys

n = int(sys.stdin.readline().rstrip())

arr = list(map(int,sys.stdin.readline().split()))

max = -1000000
min = 1000001
for i in arr:
    if i > max:
        max = i
    if i < min:
        min = i
print(min, max)
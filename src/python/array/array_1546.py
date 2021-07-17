import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))

m = arr[0]
for i in arr:
    if i > m:
        m = i

new_arr = []
for i in arr:
    new_arr.append(i/m*100)

sum = 0
for i in new_arr:
    sum += i

print(float(sum/n))

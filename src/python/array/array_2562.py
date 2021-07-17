import sys

arr = dict()
for i in range(1,10):
    arr[int(sys.stdin.readline().rstrip())] = i

temp = sorted(arr.keys())
print(temp[8])
print(arr.get(temp[8]))

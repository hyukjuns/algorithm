import sys

num = int(sys.stdin.readline().rstrip())
list_num = sys.stdin.readline().split()

min = 1000000
max = -1000000

for i in list_num:
    if int(i) <= min:
        min = int(i)
for i in list_num:
    if int(i) >= max:
        max = int(i)

print(min, max)

import sys

n = int(sys.stdin.readline())
numbers = sys.stdin.readline().rstrip()

res = 0
for i in numbers:
    res += int(i)

print(res)
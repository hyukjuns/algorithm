import sys

test_case = int(sys.stdin.readline())

for i in range(test_case):
    r, s = map(str, sys.stdin.readline().split())
    res = ""
    for j in s:
        res += int(r) * j
    print(res)

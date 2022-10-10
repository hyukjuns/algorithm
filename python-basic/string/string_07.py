import sys

a, b = map(str, sys.stdin.readline().split())

a_reverse = ""
for i in range(len(a)-1, -1 ,-1):
    a_reverse += a[i]

b_reverse = ""
for i in range(len(b)-1, -1, -1):
    b_reverse += b[i]

if int(a_reverse) >= int(b_reverse):
    print(a_reverse)
else:
    print(b_reverse)
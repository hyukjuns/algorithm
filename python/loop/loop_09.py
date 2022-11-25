import sys

element_num, x = map(int, sys.stdin.readline().split())

temp_list = sys.stdin.readline().split()
res = ""
for i in temp_list:
    if int(i) < x:
        res += f"{i} "

print(res.rstrip())

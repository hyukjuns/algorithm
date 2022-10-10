import sys

target = sys.stdin.readline().rstrip()
target = target.upper()

setted_target = set(target)

max = 0
res = ""
for i in setted_target:
    cnt = target.count(i)
    if max <= cnt:
        if max == cnt and res != "":
            res = "?"
        else:
            max = cnt
            res = i

sys.stdout.write(res)
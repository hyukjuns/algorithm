import sys

num = sys.stdin.readline().rstrip()

if int(num) < 10:
    num = "0" + num

res = ""
target = num
cnt = 0

while num != res:
    first = target[0]
    second = target[1]
    target = str(int(first) + int(second))
    res = second + target[len(target)-1]
    target = res
    cnt += 1

print(cnt)




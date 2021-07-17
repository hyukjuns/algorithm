import sys

n = sys.stdin.readline().rstrip()
if int(n) < 10:
    n = "0" + n

temp = n
cnt = 0
while 1:
    cnt += 1
    arr = list(temp)

    sum = str(int(arr[0]) + int(arr[1]))
    if int(sum) < 10:
        sum = "0" + sum

    sum_arr = list(sum)
    temp = arr[1] + sum_arr[1]
    if n == temp:
        break
print(cnt)

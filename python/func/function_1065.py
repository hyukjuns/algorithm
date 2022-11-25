import sys

num = int(sys.stdin.readline())

count = 0
if num < 100:
    count = num
else:
    count = 99
    for i in range(100, num+1):
        first = i // 100
        second = (i % 100) // 10
        third = (i % 100) % 10
        if (second - first) == (third - second):
            count += 1

sys.stdout.write(f"{count}")

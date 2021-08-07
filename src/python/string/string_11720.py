import sys

n = sys.stdin.readline().rstrip()

array = list(map(int,sys.stdin.readline().rstrip()))


sum=0
for i in array:
    sum += i

sys.stdout.write(str(sum))
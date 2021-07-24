import sys

string = list(sys.stdin.readline().rstrip())

for i in range(97, 123):
    count = 0
    for j in string:
        if i == ord(j):
            sys.stdout.write(f"{str(count)} ")
            break
        count += 1
    if count == len(string):
        sys.stdout.write('-1 ')

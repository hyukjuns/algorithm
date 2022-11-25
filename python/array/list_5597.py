import sys

students_num = []
for i in range(0, 30):
    students_num.append(i+1)
for i in range(1, 29):
    accept_num = int(sys.stdin.readline())
    students_num.remove(accept_num)
students_num.sort()
print(f"{students_num[0]}"+"\n"+f"{students_num[1]}")

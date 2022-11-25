import sys

n = int(sys.stdin.readline())

cnt = 0
for i in range(1,n+1):
    isValid = True
    temp_str = str(i)
    for j in range(0, len(temp_str)-1):
        diff = int(temp_str[j]) - int(temp_str[j+1])
        if j == 0:
            prev_diff = diff
            continue
        if prev_diff != diff:
            isValid = False
            break
        prev_diff = diff
    if isValid:
        cnt += 1
print(cnt)
        

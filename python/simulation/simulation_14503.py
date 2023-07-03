# boj 14503

import sys

#   북0
# 서3  동1
#   남2

# (d-i-1)%4
# (0-0-1)%4=3
# (0-1-1)%4=2
# (0-2-1)%4=1
# (0-3-1)%4=0

# (1-0-1)%4=0
# (1-1-1)%4=3
# (1-2-1)%4=2
# (1-3-1)%4=1

# (2-0-1)%4=1
# (2-1-1)%4=0
# (2-2-1)%4=3
# (2-3-1)%4=2

# (3-0-1)%4=2
# (3-1-1)%4=1
# (3-2-1)%4=0
# (3-3-1)%4=3

# 북 동 남 서
dir=[[-1,0],[0,1],[1,0],[0,-1]]

n, m = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
arr = [
    list(map(int, sys.stdin.readline().split())) 
    for _ in range(n)
]

def solution(r,c,d,arr):
    cnt=0
    is_end=False
    while True:
        if arr[r][c] == 0:
            cnt += 1
        arr[r][c] = 2
        for i in range(4):
            next_r = r + dir[(d-i-1)%4][0]
            next_c = c + dir[(d-i-1)%4][1]
            if arr[next_r][next_c] == 0:
                r, c, d = next_r, next_c, (d-i-1)%4
                break
            elif i == 3:
                back_r = r - dir[d][0]
                back_c = c - dir[d][1]
                if arr[back_r][back_c] == 1:
                    is_end = True
                    break
                else:
                    r, c, d = back_r, back_c, d
                    break
        if is_end:
            break
    return cnt

if __name__ == "__main__":
    result = solution(r,c,d,arr)
    print(result)


import sys

def solution():
    switch_len = int(sys.stdin.readline())
    switches = list(map(int, sys.stdin.readline().split()))
    students = int(sys.stdin.readline())
    
    for i in range(0,students):
        g, num = map(int, sys.stdin.readline().split())
        # Male
        if g == 1:
            for j in range (1,switch_len+1):
                if j / num == 0:
                    switches[j-1] ^= 1
        # Female
        else:
            j = 1
            while True:
                l = num - j
                r = num + j
                if switches[l-1] == switches[r-1]:
                    switches[l-1] ^= 1
                    switches[r-1] ^= 1
                    j = j+1
                else:
                    switches[num-1] ^= 1
                    break
    return switches
if __name__ == "__main__":
    answer = solution()
    print(answer)

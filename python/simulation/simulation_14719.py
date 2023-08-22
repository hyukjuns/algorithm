import sys

def solution():
    h, w = map(int, sys.stdin.readline().split())
    blocks = list(map(int, sys.stdin.readline().split()))
    result = 0
    # condition => 행마다 block - 1 >= 0 이 2번 이상 true 면 물 채우기
    flag = False
    for _ in range(0, h):
        temp = blocks[:]
        holes = list()
        cnt = 0
        for j in range(0, w):
            num = temp.pop()
            holes.append(num)
            if num == 0:
                if len(holes) > 1:
                    if holes[0] > 0 and holes[-1] > 0:
                        # zero count
                        cnt += holes.count(0)
                        holes.clear()
                    else:
                        holes.clear()
        for i in range(0, w):
            blocks[i] -= 1
    return cnt

if __name__ == "__main__":
    result = solution()
    print(result)
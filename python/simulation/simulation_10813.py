import sys
def solution(n, m):
    dic = {}
    for idx in range(1, n+1):
        dic[idx] = idx
    for idx in range(m):
        i, j = map(int, sys.stdin.readline().split())
        temp = dic[i]
        dic[i] = dic[j]
        dic[j] = temp
    for idx in range(1, n+1):
        print(dic[idx], end = ' ')

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    solution(n, m)

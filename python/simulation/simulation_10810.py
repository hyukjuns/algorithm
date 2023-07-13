import sys

def solution():
    n, m = map(int, sys.stdin.readline().split())
    basket = {}
    for i in range(n):
        basket[i+1] = 0

    for idx in range(m):
        i, j, k = map(int, sys.stdin.readline().split())
        for p in range (i,j+1):
            if basket[p] == 0:
                basket[p] = k
            elif basket[p] == k:
                continue
            else:
                basket[p] = k
    for i in range(1,n+1):
        print(basket[i], end=' ')

if __name__ == "__main__":
    solution()

import sys

def solution(n, m):
    
    arr = [idx+1 for idx in range(n)]

    for _ in range(m):
        i, j = map(int, sys.stdin.readline().split())
        temp_arr = arr[i-1:j]
        temp_arr.reverse()
        arr[i-1:j] = temp_arr
    
    print(*arr)

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    solution(n, m)


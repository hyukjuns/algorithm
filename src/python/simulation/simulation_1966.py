from sys import stdin
from collections import deque

tc = int(stdin.readline())
for _ in range (tc):
    n, m = map(int, stdin.readline().split())
    que = deque(map(int, stdin.readline().split()))
    cnt = 0
    while que:
        top = max(que)
        m -= 1
        pop = que.popleft()
        if top != pop:
            que.append(pop)
            if m < 0:
                m = len(que) - 1
        else:
            cnt += 1
            if m == -1:
                print(cnt)
                break

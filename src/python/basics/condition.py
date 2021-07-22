H,M = map(int, input().split(" "))

left = M - 45
if left < 0:
    left = 60 + left
    if H-1 < 0:
        print(23, left)
    else:
        print(H-1, left)
else:
    print(H, left)
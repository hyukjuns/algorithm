total_price = int(input())
category_num = int(input())

sum = 0
for i in range(0,category_num):
    price, num = map(int, input().split())
    sum += price * num

if sum == total_price:
    print("Yes")
else:
    print("No")


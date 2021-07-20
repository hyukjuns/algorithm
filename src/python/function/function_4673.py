nums = set(range(1,10001))
creater_num = set()

for i in range(1,10001):
    for j in str(i):
        i += int(j)
    creater_num.add(i)

self_num = sorted(nums - creater_num)
for i in self_num:
    print(i)
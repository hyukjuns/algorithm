import sys

nums = {}
cnt = 1
while cnt < 10:
    nums[int(sys.stdin.readline().rstrip())] = cnt
    cnt += 1

max = 0
max_index = 0
for i in nums.keys():
    if i >= max:
        max = i
        max_index = nums.get(i)
print(f"{max}\n{max_index}")

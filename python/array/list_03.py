import sys

nums = []
for i in range(10):
    nums.append(int(sys.stdin.readline().rstrip()) % 42)

nums = set(nums)
print(len(nums))

import sys

croatia_alphabet = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

test_str = sys.stdin.readline().rstrip()

cnt = 0
for i in croatia_alphabet:
    if i in test_str:
        test_str = test_str.replace(i,"1")

print(len(test_str))
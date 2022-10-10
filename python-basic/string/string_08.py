from operator import contains
import sys

dial = sys.stdin.readline().rstrip()

dial_dict = {
    "ABC": 2,
    "DEF": 3,
    "GHI": 4,
    "JKL": 5,
    "MNO": 6,
    "PQRS": 7,
    "TUV": 8,
    "WXYZ": 9
}

res = 0
for i in dial:
    for j in dial_dict.keys():
        if i in j:
            res += dial_dict[j] + 1
            break
print(res)
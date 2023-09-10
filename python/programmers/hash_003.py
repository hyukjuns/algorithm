# Clothes
from collections import Counter

clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]

category = Counter([cloth[1] for cloth in clothes])

sum = 1
for i in category.values():
    sum *= (i+1)

print(sum-1)
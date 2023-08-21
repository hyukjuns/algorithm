### Sort
```
# list
list.sort()
list.sort(key=len)
list.sort(key=lambda x:x[0])
sorted(list)
# reverse
sorted(list, reverse=True)

# dic
sorted(dict.items(), key=lambda x:x[1])
```

### Combination
```
from itertools import combinations

# combinations(list, number)
## combinations(range(4), 3) --> (0,1,2), (0,1,3), (0,2,3), (1,2,3)
target = []
target_tuple = combinations(target, 2)
target_tuple_list = list(combinations(target, 2))
```
test = ["mic","test"]

test_dict = {i: v for i, v in enumerate(test)}

for id, name in test_dict.items():
    print(id, name)

ans = str(list(test_dict))
print(ans)
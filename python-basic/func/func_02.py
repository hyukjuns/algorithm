# self number

created_number_list = []

for i in range(1, 10001):
    res = i
    for j in str(i):
        res += int(j)
    created_number_list.append(res)

result_list = []
for i in range (1, 10001):
    result_list.append(i)

for i in created_number_list:
    if i in result_list:
        result_list.remove(i)

for i in result_list:
    print(i)

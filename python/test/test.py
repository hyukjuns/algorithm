from itertools import combinations

test = ['cab','adaaa','a']
simul_list = list(combinations(test, 3))
print(simul_list)
for simul in simul_list:
    print(simul)
    for jelly in simul:
        print(jelly)


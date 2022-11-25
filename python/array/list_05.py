import sys

test_case = int(sys.stdin.readline())

for i in range(test_case):
    scores = sys.stdin.readline().rstrip()
    score = 0
    count_scores = []
    for i in scores:
        if i == "O":
            score += 1
            count_scores.append(score)
        else:
            count_scores.append(0)
            score = 0
    print(sum(count_scores))
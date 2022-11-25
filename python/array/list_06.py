import sys

test_case = int(sys.stdin.readline())

for i in range(test_case):
    scores = sys.stdin.readline().split()
    total_score = 0
    average_score = 0
    for n in range(1, int(scores[0])+1):
        total_score += int(scores[n])
    average_score = total_score / int(scores[0])
    cnt = 0
    for n in range(1, int(scores[0])+1):
        if int(scores[n]) > average_score:
            cnt += 1
    print(format(round(cnt / int(scores[0]) * 100, 3), ".3f")+"%")

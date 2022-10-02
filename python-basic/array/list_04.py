import sys

test_num = int(sys.stdin.readline())
test_scores = sys.stdin.readline().split()

max = int(test_scores[0])
for i in test_scores:
    if int(i) >= max:
        max = int(i)

fake_test_scores = []
for i in test_scores:
    fake_test_scores.append(int(i) / max * 100)

print(sum(fake_test_scores) / len(fake_test_scores))
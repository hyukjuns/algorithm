import sys

test_string = sys.stdin.readline().rstrip()

samples = {}
for i in range (0,26):
    samples[f'{chr(97+i)}'] = "-1"

cnt = 0
for i in test_string:
    if samples.get(i) == "-1":
        samples[i] = f"{cnt}"
    cnt += 1

for i in samples.values():
    sys.stdout.write(f"{i} ")
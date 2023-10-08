# Develop Function

def solution(progresses, speeds):
    answer = []

    remains = []
    for i in progresses:
        remains.append(100 - i)
    
    
    while remains:
        features = len(remains)

        for i in range(0, features):
            remains[i] = remains[i] - speeds[i]
            if remains[i] < 0:
                remains[i] = 0
        
        count_of_release = 0
        for _ in range(0, features):
            if remains[0] == 0:
                remains.pop(0)
                speeds.pop(0)
                count_of_release = count_of_release + 1

        if count_of_release != 0:
            answer.append(count_of_release)

    return answer

if __name__ == "__main__":
    progresses = [95, 90, 99, 99, 80, 99]
    speeds = [1, 1, 1, 1, 1, 1]
    ans = solution(progresses, speeds)
    print(ans)
def solution(name, yearning, photo):
    result = []
    score_by_name = dict(zip(name,yearning))

    for target in photo:
        score_sum = 0
        for i in target:
            try:
                score_sum += score_by_name[i]
            except:
                continue
        result.append(score_sum)
    return result
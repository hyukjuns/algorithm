def solution(participant, completion):
    participant_dict = {}
    sumHash = 0
    
    for name in participant:
        participant_dict[hash(name)] = name
        sumHash += hash(name)
    
    for name in completion:
        sumHash -= hash(name)
    
    return participant_dict[sumHash]


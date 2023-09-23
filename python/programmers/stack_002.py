
# ( = 40
# ) = 41

def solution(s):

    stack = list()
    for i in s:
        target = ord(i)
        if stack:
            last_member = ord(stack[-1])
            if last_member == target:
                stack.append(i)
            elif last_member > target:
                stack.append(i)
            else:
                stack.pop()
        else:
            stack.append(i)
    
    if not stack:
        return True
    return False

if __name__ == "__main__":
    s = "()()()"
    answer = solution(s)
    print(answer)
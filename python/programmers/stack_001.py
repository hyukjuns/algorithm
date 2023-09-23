


def solution(arr):

    stack = list()

    arr_len = len(arr)
    for i in range(0,arr_len):
        if i !=0 and stack[-1] == arr[i]:
            continue
        else:
            stack.append(arr[i])
    return stack


if __name__ == "__main__":
    arr = [1,1,3,3,0,1,1]
    answer = solution(arr)
    print(answer)
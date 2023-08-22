import sys

def solution():
    test_case = int(sys.stdin.readline())
    player_1 = player_2 = 100
    for _ in range(0, test_case):
        dice_1, dice_2 = map(int, sys.stdin.readline().split())
        if dice_1 > dice_2:
            player_2 -= dice_1
        elif dice_2 > dice_1:
            player_1 -= dice_2
        else:
            continue
    return f"{player_1}\n{player_2}"

if __name__ == "__main__":
    result = solution()
    print(result)
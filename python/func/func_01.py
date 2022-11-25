import sys

class SolveCls:
    def __init__(self) -> None:
        pass

    def solve(self, a: list) -> int:
        total=0
        for i in a:
            total += i
        return total

def test():
    return 10
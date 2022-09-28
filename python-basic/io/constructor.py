# __init__ 메서드는 setdata 메서드와 다르게 객체가 생성되는 시점에 자동으로 호출된다.
## a = FourCal(4,2)
class FourCal:
    def __init__(self, first, second):
        self.first = first
        self.second = second
    def setdata(self, first, second):
        self.first = first
        self.second = second
    def add(self):
        result = self.first + self.second
        return result
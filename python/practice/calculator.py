class Cal:
    def __init__(self):
        pass
    
    def add(self, a, b):
        return a + b
    
    def sub(self, a, b):
        return a - b
    
    def mul(self, a, b):
        return a * b
    
    def div(self, a, b):
        try:
            return a / b
        except ZeroDivisionError as e:
            print(e)

    def pow(self, a, b):
        return a ** b
    
    def remainder(self, a, b):
        return a % b
            

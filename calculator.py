import math

class Calculator:

    def __init__(self):
        pass

    def add(self, x, y):
        return x + y
    
    def sub(self, x, y):
        return x - y
    
    def div(self, x, y):
        return x / y
    
    def mult(self, x, y):
        return x * y
    
    def square(self, x):
        return x * x
    
    def root(self, x):
        try:
            return math.sqrt(x)
        except ValueError:
            return "Err"
        
    def exp(self, x, y):
        return x ** y
    
    def factorial(self, x):
        if x < 0:
            return "Err"
        elif x == 0:
            return 1
        else:
            factorial = 1
            while x > 0:
                factorial *= x
                x -= 1
            return factorial
    
    def inverse(self, x):
        return 1 / x
    
    def invert(self, x):
        return x * -1
    
    def sin(self, x):
        return (math.sin(x))
    
    def cos(self, x):
        return (math.cos(x))

    def tan(self, x):
        return (math.tan(x))

    def asin(self, x):
        return (math.asin(x))

    def acos(self, x):
        return (math.acos(x))
    
    def atan(self, x):
        return (math.atan(x))
    
    def log(self, x):
        return math.log(x, 10)
    
    def logBase(self, x, y):
        return math.log(x, y)

    def ln(self, x):
        return math.log(x)
    
    def inLog(self, x):
        return 10 ** x
    
    def inLogBase(self, x, y):
        return y ** x
    
    def inLn(self, x):
        return math.e ** x
    
    def constant_e(self):
        return math.e
    
    def constant_pi(self):
        return math.pi

# add lots more methods to this calculator class.

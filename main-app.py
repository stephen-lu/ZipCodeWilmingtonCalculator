from calculator import Calculator

def displayResult(state, mode):
    if state == 'Err':
        print(state)
        return
    match mode:
        case "decimal":
            print(float(state))
        case "binary":
            print(bin(state))
        case "octal":
            print(oct(state))
        case "hexadecimal":
            print(hex(state))
    return

def switchMode(mode):
    match mode:
        case "decimal":
            print("Switching to hexadecimal")
            return "hexadecimal"
        case "hexadecimal":
            print("Switching to binary")
            return "binary"
        case "binary":
            print("Switching to octal")
            return "Octal"
        case "Octal":
            print("switching to decimal")
            return "decimal"
        
def switchUnitsMode(mode):
    match mode:
        case "radians":
            print("Switching to degrees")
            return "degrees"
        case "degrees":
            print("Switching to radians")
            return "radians"

def operatorLoop(list, calc, state):
    length = len(list)
    if length == 0:
        return state
    i = 0
    try:
        state = float(list[0])
        list.pop(0)
    except ValueError:
        pass
    while i < length:
        if state == "Err":
            return state
        operator = list[i]
        if operator in ("+", "-", "*", "/", "**", "exp", "exponent", "logBase", "antilogBase", "inverseLogBase"):
            num = float(list[i+1])
        match operator:
            case "+":
                state = calc.add(state, num)
                i += 1
            case "-":
                state = calc.sub(state, num)
                i += 1
            case "/":
                if int(list[i+1]) == 0:
                    print("Cannot divide by 0")
                state = "Err"
                i += 1
            case "**" | "exp" | "exponent":
                state = calc.exp(state, num)
                i += 1
            case "*":
                state = calc.mult(state, num)
                i += 1
            case "logBase":
                state = calc.logBase(state, num)
                i += 1
            case "antilogBase" | "inverseLogBase":
                state = calc.inLogBase(state, num)
                i += 1
            case "inverse":
                state = calc.inverse(state, num)
            case "invert":
                state = calc.invert(state, num)
            case "square":
                state = calc.square(state)
            case "squareRoot":
                state = calc.root(state)
            case "sin" | "sine":
                state = calc.sin(state)
            case "cos" | "cosine":
                state = calc.cos(state)
            case "tan" | "tangent":
                state = calc.tan(state)
            case "arcsine" | "arcsin" | "asin" | "inverseSine":
                state = calc.asin(state)
            case "arccosine" | "arccosin" | "acos" | "inverseCosine":
                state = calc.acos(state)
            case "arctan" | "arctangent" | "inverseTangent":
                state = calc.atan(state)
            case "!" | "factorial":
                state = calc.factorial(state)
            case "ln" | "naturalLog":
                state = calc.ln(state)
            case "inverseLn" | "inverseNaturalLog":
                state = calc.inLn(state)
            case "antilog" | "inverseLog":
                state = calc.inLog(state)
            case "log" | "logarithm":
                state = calc.log(state)
            case _:
                state = "Err"
                i += 1
                continue
        i += 1
    return state

def performCalcLoop(calc):
    state = 0
    memory = 0
    mode = "decimal"
    unitsMode = "radians"
    while True:
        displayResult(state, mode)
        userInput = input()
        userInput = userInput.split()
        length = len(userInput)
        if length == 1:
            match userInput[0]:
                case 'quit':
                    break
                case 'clear':
                    state = 0
                case 'MC':
                    memory = 0
                case 'M+':
                    memory += state
                case 'MRC':
                    state = memory
                case 'switchMode':
                    mode = switchMode(mode)
                case 'switchUnitsMode':
                    unitsMode = switchUnitsMode(unitsMode) 
                case "e":
                    state = calc.constant_e()
                case "pi":
                    state = calc.constant_pi()
                case _:
                    state = operatorLoop(userInput, calc, state)
        elif length == 2 and userInput[1] == 'switchMode':
                mode = userInput[1]
                print("Switching to " + mode)
        elif length == 2 and userInput[1] == 'switchUnitsMode':
                unitsMode = userInput[1]
        else:
            state = operatorLoop(userInput, calc, state)
        print()
                    
# main start
def main():
    calc = Calculator()
    print("Welcome to ZipCode Calculator")
    performCalcLoop(calc)
    print("Done Calculating.")


if __name__ == '__main__':
    main()

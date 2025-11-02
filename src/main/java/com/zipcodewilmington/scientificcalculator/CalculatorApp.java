package com.zipcodewilmington.scientificcalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    
    // ---------------------- main ----------------------
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        performCalcLoop(calc);
    }

    // ---------------------- displayResult ----------------------
    public static void displayResult(double state, String mode) {
        switch (mode) {
            case "decimal" -> System.out.println(state);
            case "binary" -> System.out.println("0b" + Long.toBinaryString((long) state));
            case "octal" -> System.out.println("0o" + Long.toOctalString((long) state));
            case "hexadecimal" -> System.out.println("0x" + Long.toHexString((long) state));
            default -> System.out.println(state);
        }
    }

    // ---------------------- switchMode ----------------------
    public static String switchMode(String mode) {
        switch (mode) {
            case "decimal" -> {
                System.out.println("Switching to hexadecimal");
                return "hexadecimal";
            }
            case "hexadecimal" -> {
                System.out.println("Switching to binary");
                return "binary";
            }
            case "binary" -> {
                System.out.println("Switching to octal");
                return "octal";
            }
            case "octal" -> {
                System.out.println("Switching to decimal");
                return "decimal";
            }
            default -> {
                System.out.println("Unknown mode, defaulting to decimal");
                return "decimal";
            }
        }
    }

    // ---------------------- switchUnitsMode ----------------------
    public static String switchUnitsMode(String mode) {
        switch (mode) {
            case "radians" -> {
                System.out.println("Switching to degrees");
                return "degrees";
            }
            case "degrees" -> {
                System.out.println("Switching to radians");
                return "radians";
            }
            default -> {
                System.out.println("Unknown units mode, defaulting to radians");
                return "radians";
            }
        }
    }

    // ---------------------- operatorLoop ----------------------
    public static double operatorLoop(List<String> list, Calculator calc, double state) {
        try {
            state = Double.parseDouble(list.get(0));
            list.remove(0);
        } catch (NumberFormatException ignored) {
        }

        int length = list.size();
        if (length == 0) {
            return state;
        }

        int i = 0;
        while (i < length) {
            String operator = list.get(i);
            double num = 0;
            if (i + 1 < list.size()) {
                try {
                    num = Double.parseDouble(list.get(i + 1));
                } catch (NumberFormatException ignored) {
                }
            }

            try {
                switch (operator) {
                    case "+" -> {
                        state = calc.add(state, num);
                        i++;
                    }
                    case "-" -> {
                        state = calc.sub(state, num);
                        i++;
                    }
                    case "/" -> {
                        if (num == 0) {
                            System.out.println("Cannot divide by 0");
                            throw new IllegalArgumentException("Division by zero");
                        }
                        state = calc.div(state, num);
                        i++;
                    }
                    case "*", "mult" -> {
                        state = calc.mult(state, num);
                        i++;
                    }
                    case "**", "exp", "exponent" -> {
                        state = calc.exp(state, num);
                        i++;
                    }
                    case "logBase" -> {
                        state = calc.logBase(state, num);
                        i++;
                    }
                    case "antilogBase", "inverseLogBase" -> {
                        state = calc.inLogBase(state, num);
                        i++;
                    }
                    case "inverse" -> state = calc.inverse(state);
                    case "invert" -> state = calc.invert(state);
                    case "square" -> state = calc.square(state);
                    case "squareRoot" -> state = calc.root(state);
                    case "sin", "sine" -> state = calc.sin(state);
                    case "cos", "cosine" -> state = calc.cos(state);
                    case "tan", "tangent" -> state = calc.tan(state);
                    case "arcsine", "arcsin", "asin", "inverseSine" -> state = calc.asin(state);
                    case "arccosine", "arccosin", "acos", "inverseCosine" -> state = calc.acos(state);
                    case "arctan", "arctangent", "inverseTangent" -> state = calc.atan(state);
                    case "!", "factorial" -> state = calc.factorial((int) state);
                    case "ln", "naturalLog" -> state = calc.ln(state);
                    case "inverseLn", "inverseNaturalLog" -> state = calc.inLn(state);
                    case "antilog", "inverseLog" -> state = calc.inLog(state);
                    case "log", "logarithm" -> state = calc.log(state);
                    default -> throw new IllegalArgumentException("Unknown operator: " + operator);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return Double.NaN;
            }

            i++;
        }

        return state;
    }

    // ---------------------- performCalcLoop ----------------------
    public static void performCalcLoop(Calculator calc) {
        double state = 0;
        double memory = 0;
        String mode = "decimal";
        String unitsMode = "radians";
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.println("Welcome to ZipCode Calculator");

            while (true) {
                displayResult(state, mode);
                System.out.print("> ");
                String userInput = scanner.nextLine().trim();
                if (userInput.isEmpty()) continue;

                String[] tokens = userInput.split("\\s+");
                List<String> list = new ArrayList<>(List.of(tokens));
                int length = list.size();

                if (length == 1) {
                    String command = list.get(0);
                    switch (command) {
                        case "quit" -> {
                            System.out.println("Done Calculating.");
                            return;
                        }
                        case "clear" -> state = 0;
                        case "MC" -> memory = 0;
                        case "M+" -> memory += state;
                        case "MRC" -> state = memory;
                        case "switchMode" -> mode = switchMode(mode);
                        case "switchUnitsMode" -> unitsMode = switchUnitsMode(unitsMode);
                        case "e" -> state = calc.constantE();
                        case "pi" -> state = calc.constantPi();
                        default -> state = operatorLoop(list, calc, state);
                    }
                } else {
                    state = operatorLoop(list, calc, state);
                }

                System.out.println();
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

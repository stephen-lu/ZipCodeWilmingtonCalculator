package com.zipcodewilmington.scientificcalculator;
public class CalculatorApp {
    
    // ---------------------- main ----------------------
    public static void main(String[] args) {
        Console console = new Console();
        Calculator calc = new Calculator();
        console.performCalcLoop(calc);
    }
}

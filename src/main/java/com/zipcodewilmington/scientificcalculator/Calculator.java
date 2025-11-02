package com.zipcodewilmington.scientificcalculator;
import java.lang.Math;

public class Calculator {

    public Calculator() {
        // No initialization needed
    }

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double div(double x, double y) {
        return x / y;
    }

    public double mult(double x, double y) {
        return x * y;
    }

    public double square(double x) {
        return x * x;
    }

    public double root(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot take square root of a negative number.");
        }
        return Math.sqrt(x);
    }

    public double exp(double x, double y) {
        return Math.pow(x, y);
    }

    public long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of a negative number is undefined.");
        }
        long factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public double inverse(double x) {
        return 1 / x;
    }

    public double invert(double x) {
        return x * -1;
    }

    public double sin(double x) {
        return Math.sin(x);
    }

    public double cos(double x) {
        return Math.cos(x);
    }

    public double tan(double x) {
        return Math.tan(x);
    }

    public double asin(double x) {
        return Math.asin(x);
    }

    public double acos(double x) {
        return Math.acos(x);
    }

    public double atan(double x) {
        return Math.atan(x);
    }

    public double log(double x) {
        return Math.log10(x);
    }

    public double logBase(double x, double y) {
        return Math.log(x) / Math.log(y);
    }

    public double ln(double x) {
        return Math.log(x);
    }

    public double inLog(double x) {
        return Math.pow(10, x);
    }

    public double inLogBase(double x, double y) {
        return Math.pow(y, x);
    }

    public double inLn(double x) {
        return Math.exp(x);
    }

    public double constantE() {
        return Math.E;
    }

    public double constantPi() {
        return Math.PI;
    }
}
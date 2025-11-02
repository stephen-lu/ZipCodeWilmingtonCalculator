package com.zipcodewilmington.scientific_calculator;
import org.junit.jupiter.api.Test;
import com.zipcodewilmington.scientificcalculator.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {

        // ---------- add ----------
    @Test
    void testAdd() {
        Calculator c = new Calculator();
        assertEquals(6, c.add(3, 3));
    }

    @Test
    void testAdd2() {
        Calculator c = new Calculator();
        assertEquals(2, c.add(12, -10));
    }

    @Test
    void testAdd3() {
        Calculator c = new Calculator();
        assertEquals(13, c.add(5, 8));
    }

    // ---------- sub ----------
    @Test
    void testSubPositive() {
        Calculator c = new Calculator();
        assertEquals(5, c.sub(10, 5));
    }

    @Test
    void testSubNegative() {
        Calculator c = new Calculator();
        assertEquals(4, c.sub(-3, -7));
    }

    @Test
    void testSubMixed() {
        Calculator c = new Calculator();
        assertEquals(7, c.sub(5, -2));
    }

    // ---------- div ----------
    @Test
    void testDivNormal() {
        Calculator c = new Calculator();
        assertEquals(5, c.div(10, 2));
    }

    @Test
    void testDivFloat() {
        Calculator c = new Calculator();
        assertEquals(2.3333, c.div(7, 3), 0.0001);
    }

    @Test
    void testDivByZero() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.div(5, 0));
    }

    // ---------- mult ----------
    @Test
    void testMultPositive() {
        Calculator c = new Calculator();
        assertEquals(12, c.mult(3, 4));
    }

    @Test
    void testMultNegative() {
        Calculator c = new Calculator();
        assertEquals(-10, c.mult(-2, 5));
    }

    @Test
    void testMultZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.mult(100, 0));
    }

    // ---------- square ----------
    @Test
    void testSquarePositive() {
        Calculator c = new Calculator();
        assertEquals(25, c.square(5));
    }

    @Test
    void testSquareNegative() {
        Calculator c = new Calculator();
        assertEquals(9, c.square(-3));
    }

    @Test
    void testSquareZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.square(0));
    }

    // ---------- root ----------
    @Test
    void testRootPerfectSquare() {
        Calculator c = new Calculator();
        assertEquals(4, c.root(16));
    }

    @Test
    void testRootDecimal() {
        Calculator c = new Calculator();
        assertEquals(Math.sqrt(2), c.root(2), 0.0001);
    }

    @Test
    void testRootNegative() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.root(-4));
    }

    // ---------- exp ----------
    @Test
    void testExpPositive() {
        Calculator c = new Calculator();
        assertEquals(8, c.exp(2, 3));
    }

    @Test
    void testExpZero() {
        Calculator c = new Calculator();
        assertEquals(1, c.exp(5, 0));
    }

    @Test
    void testExpNegative() {
        Calculator c = new Calculator();
        assertEquals(0.25, c.exp(2, -2));
    }

    // ---------- factorial ----------
    @Test
    void testFactorialPositive() {
        Calculator c = new Calculator();
        assertEquals(120, c.factorial(5));
    }

    @Test
    void testFactorialZero() {
        Calculator c = new Calculator();
        assertEquals(1, c.factorial(0));
    }

    @Test
    void testFactorialNegative() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.factorial(-2));
    }

    // ---------- inverse ----------
    @Test
    void testInversePositive() {
        Calculator c = new Calculator();
        assertEquals(0.25, c.inverse(4));
    }

    @Test
    void testInverseNegative() {
        Calculator c = new Calculator();
        assertEquals(-0.5, c.inverse(-2));
    }

    @Test
    void testInverseZero() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.inverse(0));
    }

    // ---------- invert ----------
    @Test
    void testInvertPositive() {
        Calculator c = new Calculator();
        assertEquals(-10, c.invert(10));
    }

    @Test
    void testInvertNegative() {
        Calculator c = new Calculator();
        assertEquals(5, c.invert(-5));
    }

    @Test
    void testInvertZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.invert(0));
    }

    // ---------- sin ----------
    @Test
    void testSinZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.sin(0));
    }

    @Test
    void testSinPiOver2() {
        Calculator c = new Calculator();
        assertEquals(1.0, c.sin(Math.PI / 2), 0.0001);
    }

    @Test
    void testSinNegative() {
        Calculator c = new Calculator();
        assertEquals(-1.0, c.sin(-Math.PI / 2), 0.0001);
    }

    // ---------- cos ----------
    @Test
    void testCosZero() {
        Calculator c = new Calculator();
        assertEquals(1, c.cos(0));
    }

    @Test
    void testCosPi() {
        Calculator c = new Calculator();
        assertEquals(-1.0, c.cos(Math.PI), 0.0001);
    }

    @Test
    void testCosPiOver2() {
        Calculator c = new Calculator();
        assertEquals(0.0, c.cos(Math.PI / 2), 0.0001);
    }

    // ---------- tan ----------
    @Test
    void testTanZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.tan(0));
    }

    @Test
    void testTanPiOver4() {
        Calculator c = new Calculator();
        assertEquals(1.0, c.tan(Math.PI / 4), 0.0001);
    }

    @Test
    void testTanNegative() {
        Calculator c = new Calculator();
        assertEquals(-1.0, c.tan(-Math.PI / 4), 0.0001);
    }

    // ---------- asin ----------
    @Test
    void testAsinZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.asin(0));
    }

    @Test
    void testAsinOne() {
        Calculator c = new Calculator();
        assertEquals(Math.PI / 2, c.asin(1), 0.0001);
    }

    @Test
    void testAsinOutOfDomain() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.asin(2));
    }

    // ---------- acos ----------
    @Test
    void testAcosOne() {
        Calculator c = new Calculator();
        assertEquals(0, c.acos(1));
    }

    @Test
    void testAcosZero() {
        Calculator c = new Calculator();
        assertEquals(Math.PI / 2, c.acos(0), 0.0001);
    }

    @Test
    void testAcosOutOfDomain() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.acos(-2));
    }

    // ---------- atan ----------
    @Test
    void testAtanZero() {
        Calculator c = new Calculator();
        assertEquals(0, c.atan(0));
    }

    @Test
    void testAtanOne() {
        Calculator c = new Calculator();
        assertEquals(Math.PI / 4, c.atan(1), 0.0001);
    }

    @Test
    void testAtanNegative() {
        Calculator c = new Calculator();
        assertEquals(-Math.PI / 4, c.atan(-1), 0.0001);
    }

    // ---------- log ----------
    @Test
    void testLog10() {
        Calculator c = new Calculator();
        assertEquals(1, c.log(10));
    }

    @Test
    void testLog100() {
        Calculator c = new Calculator();
        assertEquals(2, c.log(100));
    }

    @Test
    void testLogInvalid() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.log(-10));
    }

    // ---------- logBase ----------
    @Test
    void testLogBase8Base2() {
        Calculator c = new Calculator();
        assertEquals(3, c.logBase(8, 2));
    }

    @Test
    void testLogBase27Base3() {
        Calculator c = new Calculator();
        assertEquals(3, c.logBase(27, 3));
    }

    @Test
    void testLogBaseInvalid() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.logBase(-1, 2));
    }

    // ---------- ln ----------
    @Test
    void testLnE() {
        Calculator c = new Calculator();
        assertEquals(1, c.ln(Math.E), 0.0001);
    }

    @Test
    void testLn1() {
        Calculator c = new Calculator();
        assertEquals(0, c.ln(1), 0.0001);
    }

    @Test
    void testLnInvalid() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.ln(0));
    }

    // ---------- inLog ----------
    @Test
    void testInLog2() {
        Calculator c = new Calculator();
        assertEquals(100, c.inLog(2));
    }

    @Test
    void testInLog0() {
        Calculator c = new Calculator();
        assertEquals(1, c.inLog(0));
    }

    @Test
    void testInLogNegative() {
        Calculator c = new Calculator();
        assertEquals(0.1, c.inLog(-1), 0.0001);
    }

    // ---------- inLogBase ----------
    @Test
    void testInLogBase2Base3() {
        Calculator c = new Calculator();
        assertEquals(9, c.inLogBase(2, 3));
    }

    @Test
    void testInLogBase0Base5() {
        Calculator c = new Calculator();
        assertEquals(1, c.inLogBase(0, 5));
    }

    @Test
    void testInLogBaseNegativeExp() {
        Calculator c = new Calculator();
        assertEquals(0.5, c.inLogBase(-1, 2), 0.0001);
    }

    // ---------- inLn ----------
    @Test
    void testInLn1() {
        Calculator c = new Calculator();
        assertEquals(Math.E, c.inLn(1), 0.0001);
    }

    @Test
    void testInLn0() {
        Calculator c = new Calculator();
        assertEquals(1, c.inLn(0), 0.0001);
    }

    @Test
    void testInLnNegative() {
        Calculator c = new Calculator();
        assertEquals(1 / Math.E, c.inLn(-1), 0.0001);
    }
    
}

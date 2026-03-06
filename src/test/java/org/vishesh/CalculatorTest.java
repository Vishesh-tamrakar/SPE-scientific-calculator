package org.vishesh;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(5.0, Calculator.add(2,3), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, Calculator.subtract(3,2), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, Calculator.multiply(2,3), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, Calculator.divide(6,3), 0.001);
    }

    @Test
    public void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2,3), 0.001);
    }
}

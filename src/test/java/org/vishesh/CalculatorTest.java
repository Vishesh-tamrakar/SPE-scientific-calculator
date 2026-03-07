package org.vishesh;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    // ADDITION
    @Test
    public void testAddition() {
        assertEquals(11.0, Calculator.add(6,5), 0.001);   
        assertEquals(-1.0, Calculator.add(-2,1), 0.001);  
        assertEquals(0.0, Calculator.add(0,0), 0.001);    
    }

    // SUBTRACTION
    @Test
    public void testSubtraction() {
        assertEquals(2.0, Calculator.subtract(5,3), 0.001);   
        assertEquals(-5.0, Calculator.subtract(-3,2), 0.001); 
        assertEquals(0.0, Calculator.subtract(0,0), 0.001);   
    }

    // MULTIPLICATION
    @Test
    public void testMultiplication() {
        assertEquals(6.0, Calculator.multiply(2,3), 0.001);   
        assertEquals(-6.0, Calculator.multiply(-2,3), 0.001); 
        assertEquals(0.0, Calculator.multiply(5,0), 0.001);   
    }

    // DIVISION
    @Test
    public void testDivision() {
        assertEquals(2.0, Calculator.divide(6,3), 0.001);   
        assertEquals(-2.0, Calculator.divide(-6,3), 0.001); 
        assertEquals(0.5, Calculator.divide(1,2), 0.001);   
    }

    // DIVIDE BY ZERO
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(5,0);
    }

    // SQUARE ROOT
    @Test
    public void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9), 0.001);   
        assertEquals(0.0, Calculator.sqrt(0), 0.001);   
        assertEquals(4.0, Calculator.sqrt(16), 0.001);  
    }

    // NEGATIVE SQRT
    @Test(expected = ArithmeticException.class)
    public void testNegativeSqrt() {
        Calculator.sqrt(-4);
    }

    // FACTORIAL
    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5)); 
        assertEquals(1, Calculator.factorial(0));   
        assertEquals(1, Calculator.factorial(1));   
    }

    // POWER
    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2,3), 0.001);   
        assertEquals(1.0, Calculator.power(5,0), 0.001);   
        assertEquals(0.25, Calculator.power(2,-2), 0.001); 
    }

    // NATURAL LOG
    @Test
    public void testLn() {
        assertEquals(Math.log(5), Calculator.ln(5), 0.001);  
        assertEquals(0.0, Calculator.ln(1), 0.001);          
        assertEquals(Math.log(2), Calculator.ln(2), 0.001);  
    }

    // NEGATIVE LN
    @Test(expected = ArithmeticException.class)
    public void testNegativeLn() {
        Calculator.ln(-2);
    }
}
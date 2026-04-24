package com.shivam.monocept.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.shivam.monocept.calculator.Calculator;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
    Calculator calculator=new Calculator();
    
    @ParameterizedTest
    @Order(1)
    @CsvSource({
    	"1,2,3"
    	,"4,-5,-1"
    	,"2,-2,0"
    	,"-1,-1,-2"
    	,"-3,-3,-6"
    	
    })
    void shouldbeMultipleCasesOfAddition(int a,int b,int expected)
    {
    	assertEquals(expected, calculator.add(a, b));
    } 
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
    	"1,2,-1"
    	,"4,-5,9"
    	,"2,-2,4"
    	,"-1,-1,0"
    	,"-3,-3,0",
    	"4,-111,115"
    	
    })
    void shouldbeMultipleCasesOfSuntraction(int a,int b,int expected)
    {
    	assertEquals(expected, calculator.subtract(a, b));
    } 
    
    @ParameterizedTest
    @Order(3)
    @CsvSource({
    	"1,2,2"
    	,"4,-5,-20"
    	,"2,-2,-4"
    	,"-1,-1,1"
    	,"-3,-3,9"
    	
    })
    void shouldbeMultipleCasesOfMultification(int a,int b,int expected)
    {
    	assertEquals(expected, calculator.multiply(a, b));
    }  
    @ParameterizedTest
    @Order(4)
    @CsvSource({
    	"1,1,1"
    	,"4,2,2"
    	,"2,-2,-1"
    	,"-1,-1,1"
    	,"-6,-3,2",
    	"0,9,0"
    	,"0,5,0"
    	
    })
    void shouldbeMultipleCasesOfdivide(int a,int b,int expected)
    {
    	assertEquals(expected, calculator.divide(a, b));
    } 
    
    @ParameterizedTest
    @Order(4)
    @CsvSource({
        "1,0",
        "4,0",
        "-1,0",
        "0,0"
    })
    void shouldThrowExceptionWhenDivideByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
    
    /*
	@Test
	void twoPostiveNumber() {
		assertEquals(4, calculator.add(2, 2));
		
	}
	@Test
	void AdditionNegativeNo()
	{
		assertNotEquals(-2,calculator.add(-1,-2));
	}
	@Test
	void AddtionOfOnePostiveOrOneNegative()
	{
		assertEquals(4,calculator.add(-1, 5));
	}
	@Test
    void testAddZero() {
        assertEquals(5, calculator.add(5, 0));
    }
	
	 @Test
	    void testSubtractPositive() {
	        assertEquals(2, calculator.subtract(5, 3));
	    }

	    @Test
	    void testSubtractNegative() {
	        assertEquals(0, calculator.subtract(-5, -5));
	    }

	    @Test
	    void testSubtractMixed() {
	        assertEquals(10, calculator.subtract(5, -5));
	    }

	    @Test
	    void testSubtractZero() {
	        assertEquals(5, calculator.subtract(5, 0));
	    }

	    @Test
	    void testSubtractNotEquals() {
	        assertNotEquals(1, calculator.subtract(5, 3));
	    }
	    @Test
	    void testMultiplyPositive() {
	        assertEquals(25, calculator.multiply(5, 5));
	    }

	    @Test
	    void testMultiplyNegative() {
	        assertEquals(25, calculator.multiply(-5, -5));
	    }

	    @Test
	    void testMultiplyMixed() {
	        assertEquals(-25, calculator.multiply(5, -5));
	    }

	    @Test
	    void testMultiplyZero() {
	        assertEquals(0, calculator.multiply(5, 0));
	    }

	    @Test
	    void testMultiplyNotEquals() {
	        assertNotEquals(30, calculator.multiply(5, 5));
	    }

	   
	    @Test
	    void testDividePositive() {
	        assertEquals(2, calculator.divide(10, 5));
	    }

	    @Test
	    void testDivideNegative() {
	        assertEquals(2, calculator.divide(-10, -5));
	    }

	    @Test
	    void testDivideMixed() {
	        assertEquals(-2, calculator.divide(10, -5));
	    }

	    @Test
	    void testDivideZeroResult() {
	        assertEquals(0, calculator.divide(0, 5));
	    }

	    @Test
	    void testDivideByZero() {
	        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
	    }
	    */
}

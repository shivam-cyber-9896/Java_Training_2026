package com.shivam.monocept.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.shivam.monocept.calculator.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DivideTest {
	
	Calculator divide;

	@BeforeEach
	void setUp() {
	    divide = new Calculator();
	}
	@ParameterizedTest
    @Order(1)
    @CsvSource({
        "1,0",
        "4,0",
        "-1,0",
        "0,0"
    })
    void shouldThrowExceptionWhenDivideByZero(int a, int b) {
		ArithmeticException exception=  assertThrows(ArithmeticException.class, () -> divide.divide(a, b));
		assertEquals("Cannot divide by zero", exception.getMessage());
	}
	
	@Test
	@Order(2)
	void ExceptionThrowTestInDivide() {
		
		ArithmeticException exception= assertThrows(ArithmeticException.class,() ->divide.divide(3, 0));
		assertEquals("Cannot divide by zero", exception.getMessage());
	}
	  @ParameterizedTest
	  @Order(3)
	    @CsvSource(value = {
	        "10, 5, 2",
	        "9, 3, 3",
	        "-10, 5, -2",
	        "10, -5, -2",
	        "0, 5, 0",
	        "10, 0, NULL"   
	    }, nullValues = "NULL")
	    void shouldHandleDivisionCorrectly(int a, int b, Integer expected) {

	        if (expected == null) {
	            ArithmeticException ex = assertThrows(
	                ArithmeticException.class,
	                () -> divide.divide(a, b)
	            );
	            assertEquals("Cannot divide by zero", ex.getMessage());
	        } else {
	            assertEquals(expected.intValue(), divide.divide(a, b));
	        }
	    }
	

}

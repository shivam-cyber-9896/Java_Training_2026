package com.shivam.monocept.stringUtilit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.shivam.monocept.stringutility.StringUtility;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StringUtlityTest {
	StringUtility string = new StringUtility();
	
	@ParameterizedTest
	@NullSource
	@EmptySource
	void shouldReturnTrueWhenStringIsNullOrEmpty(String input) {
	    assertTrue(string.isEmpty(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "Hello"})
	void shouldReturnFalseWhenStringIsNotEmpty(String input) {
	    assertFalse(string.isEmpty(input));
	}

	 @ParameterizedTest
	    @ValueSource(strings = {"hello", "java", "test",""," "})
	    void shouldConvertToUpperCaseWhenInputIsValid(String input) {
	        assertEquals(input.toUpperCase(), string.toUpperCase(input));
	    }
     
	  @ParameterizedTest
	  
	    @CsvSource({
	        
	        "'', 0", 
	        " ,1",
	        "e', 1",      
	        "'   ', 3",    
	        "Hello, 5",
	        "Java, 4",
	        "Test, 4"
	    })
	    void shouldReturnCorrectLengthForVariousInputs(String input, Integer expected) {

	        assertEquals(expected, string.getLength(input));
	        
	    }
	/*
	@Test
	void testIsEmptyNull() {
		assertTrue(string.isEmpty(null));
	}

	@Test
	void StringIsEmptyEmptyString() {
		assertTrue(string.isEmpty(""));
	}

	@Test
	void StringIsEmptyWhitespace() {
		assertFalse(string.isEmpty(" "));
	}

	@Test
	void StringIsEmptyNormalString() {
		assertFalse(string.isEmpty("Hello"));
	}

	@Test
	void ShouldStringToUpperCaseNull() {
		assertNull(string.toUpperCase(null));
	}

	@Test
	void testToUpperCaseEmpty() {
		assertNotNull(string.toUpperCase(""));
		assertTrue(string.toUpperCase("").isEmpty());
	}

	@Test
	void testToUpperCaseWhitespace() {
		assertEquals(" ", string.toUpperCase(" "));
	}

	@Test
	void testToUpperCaseNormal() {
		assertEquals("HELLO", string.toUpperCase("hello"));
	}

	@Test
	void testGetLengthNull() {
		assertNull(string.getLength(null));
	}

	@Test
	void testGetLengthEmpty() {
		assertNotNull(string.getLength(""));
		assertEquals(0, string.getLength(""));
	}

	@Test
	void StringGetLengthWhitespaceChecker() {
		assertEquals(1, string.getLength(" "));
	}

	@Test
	void ShouldStringGetLengthNormal() {
		assertEquals(5, string.getLength("Hello"));
	}
*/
}

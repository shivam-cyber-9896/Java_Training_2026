package com.shivam.monocept.passsword.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.shivam.monocept.password.PasswordVaidater;

class PasswordVaildaterTest {
	PasswordVaidater validator;  
	
	@BeforeEach
	void setup()
	{
		validator=new PasswordVaidater();	
	}
	@AfterAll
	@ParameterizedTest
    @CsvSource(value = {
       
        "Password1, true",

      
        "Pass1, false",       
        "password1, false",  
        "Password, false",    
        "NULL, false",
        "'', false"
    }, nullValues = "NULL")
    void shouldValidatePasswordCorrectly(String input, boolean expected) {
        assertEquals(expected, validator.isValid(input));
    }
	
/*	@Test
	void ShouldReturnTheVaildPassword() {
		assertTrue(validator.isValid("Passsword2"));
	}
	 @Test
	    void shouldReturnFalseWhenPasswordIsTooShort() {
	        assertFalse(validator.isValid("Pass1"));
	    }

	   
	    @Test
	    void shouldReturnFalseWhenNoUppercase() {
	        assertFalse(validator.isValid("password1"));
	    }

	    
	    @Test
	    void shouldReturnFalseWhenNoDigit() {
	        assertFalse(validator.isValid("Password"));
	    }

	   
	    @Test
	    void shouldReturnFalseWhenPasswordIsNull() {
	        assertFalse(validator.isValid(null));
	    }

	  
	    @Test
	    void shouldReturnFalseWhenPasswordIsEmpty() {
	        assertFalse(validator.isValid(""));
	    } */
}

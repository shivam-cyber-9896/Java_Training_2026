package com.shivam.monocept.marks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.shivam.monocept.marks.Marks;

class MarksTest {

	
	
	    Marks validator;

	   
	    @BeforeEach
	    void setUp() {
	        validator = new Marks();
	    }

	    @AfterEach
	    void tearDown() {
	        validator = null;
	    }

	   /* 
	    @Test
	    void shouldReturnTrueWhenMarksIsZero() {
	        assertTrue(validator.isValidMarks(0));
	    }

	    @Test
	    void shouldReturnTrueWhenMarksIsHundred() {
	        assertTrue(validator.isValidMarks(100));
	    }

	    @Test
	    void shouldReturnFalseWhenMarksIsBelowZero() {
	        assertFalse(validator.isValidMarks(-1));
	    }

	    @Test
	    void shouldReturnFalseWhenMarksIsAboveHundred() {
	        assertFalse(validator.isValidMarks(101));
	    }
*/
	    

	    @ParameterizedTest
	    @CsvSource({
	        "0, true",
	        "1, true",
	        "99, true",
	        "100, true",
	        "-1, false",
	        "101, false"
	    })
	    void shouldValidateMarksBoundaryCorrectly(int marks, boolean expected) {
	        assertEquals(expected, validator.isValidMarks(marks));
	    }
	}



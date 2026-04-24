package com.shivam.monocept.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.shivam.monocept.user.User;

class UserTest {

	 User user;
	 @ParameterizedTest
	    @CsvSource({
	        "Shivam, 22",
	        "John, 30",
	        "Alice, 25"
	    })
	    void shouldCreateUserWhenDataIsValid(String name, int age) {
	         user = new User(name, age);

	        assertNotNull(user);
	        assertEquals(name, user.getName());
	        assertEquals(age, user.getAge());
	    }
	 @ParameterizedTest
	    @CsvSource({
	        ", 22",
	        "J, -30"
	    })
	    void shouldCreateUserWhenDataIsInvaildThrowException(String name, int age) {
		 assertThrows(IllegalArgumentException.class, () -> {
	            new User(name, age);
	        });

	        
	    }
	 
/*
	    // rum before each test case
	    @BeforeEach
	    void setUp() {
	        user = new User("Shivam", 22);
	        System.out.println("Setup executed");
	    }

	    // Runs after each test
	    @AfterEach
	    void tearDown() {
	        user = null;
	        System.out.println("Cleanup executed");
	    }

	 
	    @Test
	    void ShouldUserIsVaild() {
	        assertNotNull(user);
	        assertEquals("Shivam", user.getName());
	        assertEquals(22, user.getAge());
	    }

	  
	    @Test
	    void ShouldUserNameThrowAErrorOnNullName() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new User(null, 20);
	        });
	    }

	   
	    @Test
	    void ShouldUserThrowInvalidAge() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new User("John", -5);
	        });
	    }
*/
}

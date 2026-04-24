package com.shivam.monocept.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;

import com.shivam.monocept.user.User2;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User2Test {

	
	
	User2 user;
	@ParameterizedTest
	@Order(1)
	@CsvSource({
	"shivam,18,active",
	"sid,17,not avialable"
	})
	void shouldCreateUserWithMultipleParameters(String name, int age, String status) {

        user = new User2(name, age, status);

        assertAll("User validation",
            () -> assertEquals(name, user.getName()),
            () -> assertEquals(age, user.getAge()),
            () -> assertEquals(status, user.getStatus())
        );
    }
	@Test
	void testUserProperties() {
	  user=new User2("Shivam",18,"Single");
	 
	 
	 assertAll(
			 () -> assertEquals("Shivam", user.getName()),
	            () -> assertEquals(18, user.getAge()),
	            () -> assertNotEquals("Active", user.getStatus()),
	            () -> assertEquals("Single",user.getStatus()));
	}
 
}

package com.shivam.monocept.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BankTest {

	 Bank account;
	    @ParameterizedTest
	    @Order(1)
	    @CsvSource({
	        "500, 1500",
	        "200, 1200",
	        "1000, 2000"
	    })
	    void shouldIncreaseBalanceWhenDepositIsValid(double amount, double expected) {
	        account.deposit(amount);
	        assertEquals(expected, account.getBalance());
	    }
	    @ParameterizedTest
	    @Order(2)
	    @CsvSource({
	        "400, 600",
	        "200, 800",
	        "1000, 0"
	    })
	    void shouldDecreaseBalanceWhenWithdrawIsValid(double amount, double expected) {
	        account.withdraw(amount);
	        assertEquals(expected, account.getBalance());
	    }
	    @ParameterizedTest
	    @Order(3)
	    @CsvSource({
	        "200, 300, 900",
	        "500, 200, 1300",
	        "100, 100, 1000"
	    })
	    void shouldHandleMultipleOperations(double deposit, double withdraw, double expected) {
	        account.deposit(deposit);
	        account.withdraw(withdraw);
	        assertEquals(expected, account.getBalance());
	    }
	 
	    @ParameterizedTest
	    @CsvSource({
	        "-100",
	        "-500",
	        "0"
	    })
	    void shouldThrowExceptionWhenDepositIsInvalid(double amount) {
	        assertThrows(IllegalArgumentException.class, () -> account.deposit(amount));
	    }
	    @BeforeEach
	    void setUp() {
	        account = new Bank(1000); 
	        System.out.println("Setup: Account created");
	    }

	    
	    @AfterEach
	    void tearDown() {
	        account = null;
	        System.out.println("Cleanup: Account removed");
	    }
	 /*   @Test
	    void testDepositValid() {
	        account.deposit(500);
	        assertEquals(1500, account.getBalance());
	    }
	    @Test
	    void testWithdrawValid() {
	        account.withdraw(400);
	        assertEquals(600, account.getBalance());
	    }
	    @Test
	    void testMultipleOperations() {
	        account.deposit(200);   
	        account.withdraw(300);  
	        assertEquals(900, account.getBalance());
	    }
	    @Test
	    void testDepositInvalid() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.deposit(-100);
	        });
	    }

	    @Test
	    void testWithdrawInvalidAmount() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(-50);
	        });
	    }

	    @Test
	    void testWithdrawMoreThanBalance() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(2000);
	    
	        });
	    }
*/
}

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
class BankServiceTest {

	BankService bank;

    
    @BeforeEach
    void setUp() {
        bank = new BankService();
        
    }

    
    @AfterEach
    void tearDown() {
        bank=null;
    }

   
    @Test
    void shouldWithdrawSuccessfully() {
        double result = bank.withdraw(1000, 500);
        assertEquals(500, result);
    }

   
    @Test
    @Order(1)
    void shouldThrowExceptionWhenAmountGreaterThanBalance() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(1000, 1500));

        assertEquals("Insufficient balance", ex.getMessage());
    }

    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
        "1000, 0",
        "1000, -100",
        "500, -1"
    })
    void shouldThrowExceptionWhenAmountInvalid(double balance, double amount) {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(balance, amount));

        assertEquals("Amount must be greater than 0", ex.getMessage());
    }
    @ParameterizedTest
    @Order(3)
    @CsvSource({
        "1000, 1500",
        "500, 600",
        "200, 1000"
    })
    void shouldThrowExceptionWhenAmountGreaterThanBalance(double balance, double amount) {
        BankService bank = new BankService();

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(balance, amount));

        assertEquals("Insufficient balance", ex.getMessage());
    }
}

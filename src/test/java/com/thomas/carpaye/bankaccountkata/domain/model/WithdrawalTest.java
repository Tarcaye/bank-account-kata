package com.thomas.carpaye.bankaccountkata.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WithdrawalTest {

    @Test
    public void cannot_create_a_negative_withdraw() {
        // Arrange
        String accountId = "1234567890123";
        int money = -12000;

        // Act
        assertThatThrownBy(()->Deposit.of(money))
                // Assert
                .isExactlyInstanceOf(InvalidDepositAmountException.class)
                .hasMessage("Invalid amount for deposit : " + money);
    }
}
package com.thomas.carpaye.bankaccountkata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SaveMoneyTest {

//    In order to save money
//    As a bank client
//    I want to make a deposit in my account

    @Test
    public void must_save_money_on_bank_account_for_bank_client_when_deposit_money() {
        // Arrange
        String accountId = "1234567890123";
        int money = 12000;

        // Act
        save(accountId, money);

        // Assert
        Assertions.assertThat(balance(accountId)).isEqualTo(money);
    }

    private int balance(String accountId) {
        return 0;
    }

    private void save(String account, int money) {
    }

}

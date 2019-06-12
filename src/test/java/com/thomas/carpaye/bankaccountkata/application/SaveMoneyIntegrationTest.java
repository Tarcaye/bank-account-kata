package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryDepositRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SaveMoneyIntegrationTest {

    private DepositRepository depositRepository = new InMemoryDepositRepository();
    private SaveMoney saveMoney = new SaveMoney(depositRepository);

//    In order to save money
//    As a bank client
//    I want to make a deposit in my account

    @Test
    public void must_save_money_on_bank_account_for_bank_client_when_deposit_money() {
        // Arrange
        String accountId = "1234567890123";
        int money = 12000;

        // Act
        saveMoney.save(accountId, money);

        // Assert
        Assertions.assertThat(balance(accountId).getValue()).isEqualTo(money);
    }

    @Test
    public void must_save_money_on_bank_account_for_bank_client_when_deposit_money_multiple_times() {
        // Arrange
        String accountId = "1234567890123";
        int money = 12000;

        // Act
        saveMoney.save(accountId, money);
        saveMoney.save(accountId, money);

        // Assert
        Assertions.assertThat(balance(accountId).getValue()).isEqualTo(money * 2);
    }

    private Balance balance(String accountId) {
        return new Balance(12000);
    }

}

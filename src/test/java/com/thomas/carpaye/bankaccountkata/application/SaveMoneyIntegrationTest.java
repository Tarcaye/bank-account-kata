package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.PastTransactionsRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.InvalidDepositAmountException;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryPastTransactionsRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SaveMoneyIntegrationTest {

    private PastTransactionsRepository pastTransactionsRepository = new InMemoryPastTransactionsRepository();

    private SaveMoney saveMoney = new SaveMoney(pastTransactionsRepository);
    private CheckBalance checkBalance = new CheckBalance(pastTransactionsRepository);

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
        Balance balance = checkBalance.getAccountBalance(new Account(accountId));
        assertThat(balance.getValue()).isEqualTo(money);
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
        Balance balance = checkBalance.getAccountBalance(new Account(accountId));
        assertThat(balance.getValue()).isEqualTo(money * 2);
    }

    @Test
    public void must_throw_an_exception_when_deposit_a_negative_amount_of_money() {
        // Arrange
        String accountId = "1234567890123";
        int money = -12000;

        // Act
        assertThatThrownBy(()->saveMoney.save(accountId, money))
        // Assert
        .isExactlyInstanceOf(InvalidDepositAmountException.class)
        .hasMessage("Invalid amount for deposit : " + money);
    }

    private Balance balance(String accountId) {
        return new Balance(12000);
    }

}

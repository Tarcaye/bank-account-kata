package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.*;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryPastTransactionsRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.SimpleOverdraftRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WithdrawMoneyIntegrationTest {

    private PastTransactionsRepository pastTransactionsRepository = new InMemoryPastTransactionsRepository();

    private SaveMoney saveMoney = new SaveMoney(pastTransactionsRepository);
    private CheckBalance checkBalance = new CheckBalance(pastTransactionsRepository);

    private OverdraftRepository overdraftRepository = new SimpleOverdraftRepository();
    private WithdrawMoney withdrawMoney = new WithdrawMoney(checkBalance, pastTransactionsRepository, overdraftRepository);


    @Test
    public void must_withdraw_savings_from_bank_account() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(accountId, 12000);

        // Act
        withdrawMoney.withdraw(accountId, 10000);

        // Assert
        Balance balance = checkBalance.getAccountBalance(new Account(accountId));
        assertThat(balance.getValue()).isEqualTo(12000 - 10000);
    }

    @Test
    public void cannot_withdraw_savings_from_bank_account_when_balance_is_under_overdraft() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(accountId, 12000);

        // Act
        assertThatThrownBy(() -> withdrawMoney.withdraw(accountId, 100000000))
        .isExactlyInstanceOf(InsufficientFundsException.class);

        // Assert
        Balance balance = checkBalance.getAccountBalance(new Account(accountId));
        assertThat(balance.getValue()).isEqualTo(12000);
    }

}

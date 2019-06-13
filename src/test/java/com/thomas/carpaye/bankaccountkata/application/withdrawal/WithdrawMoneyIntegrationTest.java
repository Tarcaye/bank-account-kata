package com.thomas.carpaye.bankaccountkata.application.withdrawal;

import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalance;
import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalanceQuery;
import com.thomas.carpaye.bankaccountkata.application.deposit.SaveMoney;
import com.thomas.carpaye.bankaccountkata.application.deposit.SaveMoneyCommand;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.InsufficientFundsException;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OverdraftRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryOperationsRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.SimpleOverdraftRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WithdrawMoneyIntegrationTest {

    private InMemoryOperationsRepository operationsRepository = new InMemoryOperationsRepository();

    private SaveMoney saveMoney = new SaveMoney(operationsRepository);
    private CheckBalance checkBalance = new CheckBalance(operationsRepository);

    private OverdraftRepository overdraftRepository = new SimpleOverdraftRepository();
    private WithdrawMoney withdrawMoney = new WithdrawMoney(operationsRepository, overdraftRepository);


    @Test
    public void must_withdraw_savings_from_bank_account() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(new SaveMoneyCommand(accountId, 12000));

        // Act
        withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, 10000));

        // Assert
        Balance balance = checkBalance.getAccountBalance(new CheckBalanceQuery(accountId));
        assertThat(balance.getValue()).isEqualTo(12000 - 10000);
    }

    @Test
    public void cannot_withdraw_savings_from_bank_account_when_balance_is_under_overdraft() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(new SaveMoneyCommand(accountId, 12000));

        // Act
        assertThatThrownBy(() -> withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, 100000000)))
                .isExactlyInstanceOf(InsufficientFundsException.class);

        // Assert
        Balance balance = checkBalance.getAccountBalance(new CheckBalanceQuery(accountId));
        assertThat(balance.getValue()).isEqualTo(12000);
    }

}

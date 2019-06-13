package com.thomas.carpaye.bankaccountkata.application.deposit;

import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalance;
import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalanceQuery;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.common.InvalidDepositAmountException;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OperationsRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryOperationsRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SaveMoneyIntegrationTest {

    private InMemoryOperationsRepository operationsRepository = new InMemoryOperationsRepository();

    private SaveMoney saveMoney = new SaveMoney(operationsRepository);
    private CheckBalance checkBalance = new CheckBalance(operationsRepository);

    @Test
    public void must_save_money_on_bank_account_for_bank_client_when_deposit_money() {
        // Arrange
        String accountId = "1234567890123";
        int money = 12000;

        // Act
        saveMoney.save(new SaveMoneyCommand(accountId, money));

        // Assert
        Balance balance = checkBalance.getAccountBalance(new CheckBalanceQuery(accountId));
        assertThat(balance.getValue()).isEqualTo(money);
    }

    @Test
    public void must_save_money_on_bank_account_for_bank_client_when_deposit_money_multiple_times() {
        // Arrange
        String accountId = "1234567890123";
        int money = 12000;

        // Act
        saveMoney.save(new SaveMoneyCommand(accountId, money));
        saveMoney.save(new SaveMoneyCommand(accountId, money));

        // Assert
        Balance balance = checkBalance.getAccountBalance(new CheckBalanceQuery(accountId));
        assertThat(balance.getValue()).isEqualTo(money * 2);
    }

    @Test
    public void must_throw_an_exception_when_deposit_a_negative_amount_of_money() {
        // Arrange
        String accountId = "1234567890123";
        int money = -12000;

        // Act
        assertThatThrownBy(()->saveMoney.save(new SaveMoneyCommand(accountId, money)))
        // Assert
        .isExactlyInstanceOf(InvalidDepositAmountException.class)
        .hasMessage("Invalid amount for deposit : " + money);
    }

}

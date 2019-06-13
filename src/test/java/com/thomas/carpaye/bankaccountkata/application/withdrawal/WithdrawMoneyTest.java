package com.thomas.carpaye.bankaccountkata.application.withdrawal;

import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalance;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.InsufficientFundsException;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OperationsRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OverdraftRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.Withdrawal;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class WithdrawMoneyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private OperationsRepository operationsRepository;

    @Mock
    private OverdraftRepository overdraftRepository;

    @InjectMocks
    private WithdrawMoney withdrawMoney;

    @Test
    public void must_withdraw_money() {
        // Arrange
        int money = 10;
        String accountId = "1234567890123";

        givenBalance(accountId, 1000);
        givenOverdraft(-5000);

        // Act
        withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, money));


        // Assert
        Mockito.verify(operationsRepository).add(any(Account.class), any(Withdrawal.class));
    }

    @Test
    public void cannot_withdraw_money_if_balance_is_low() {
        // Arrange
        int money = 100000;
        String accountId = "1234567890123";
        givenBalance(accountId, 0);
        givenOverdraft(0);

        // Act
        Assertions.assertThatThrownBy(() -> withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, money)))
                .isExactlyInstanceOf(InsufficientFundsException.class)
                .hasMessage("Insufficient funds for withdraw : Withdrawal{amount=100000} on account : Account{accountId='1234567890123'}");
    }

    private void givenOverdraft(int overDraft) {
        when(overdraftRepository.getOverdraft(any())).thenReturn(new Amount(overDraft));
    }

    private void givenBalance(String accountId, int balance) {
        when(operationsRepository.getBalance(eq(Account.of(accountId)))).thenReturn(new Balance(balance));
    }
}
package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.*;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WithdrawMoneyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PastTransactionsRepository pastTransactionsRepository;

    @Mock
    private CheckBalance checkBalance;

    @Mock
    private OverdraftRepository overdraftRepository;

    @InjectMocks
    private WithdrawMoney withdrawMoney;

    @Test
    public void must_withdraw_money() {
        // Arrange
        int money = 10;
        String accountId = "1234567890123";

        givenBalance(1000);
        givenOverdraft(-5000);

        // Act
        withdrawMoney.withdraw(accountId, money);


        // Assert
        Mockito.verify(pastTransactionsRepository).add(any(Account.class), any(Withdrawal.class));
    }

    @Test
    public void cannot_withdraw_money_if_balance_is_low() {
        // Arrange
        int money = 100000;
        String accountId = "1234567890123";
        givenBalance(0);
        givenOverdraft(0);

        // Act
        Assertions.assertThatThrownBy(() -> withdrawMoney.withdraw(accountId, money))
        .isExactlyInstanceOf(InsufficientFundsException.class)
        .hasMessage("Insufficient funds for withdraw : Withdrawal{, amount=Amount{value=100000}} on account : Account{accountId='1234567890123'}");
    }

    private void givenOverdraft(int overDraft) {
        when(overdraftRepository.getOverdraft(any())).thenReturn(new Amount(overDraft));
    }

    private void givenBalance(int balance) {
        when(checkBalance.getAccountBalance(any())).thenReturn(new Balance(balance));
    }
}
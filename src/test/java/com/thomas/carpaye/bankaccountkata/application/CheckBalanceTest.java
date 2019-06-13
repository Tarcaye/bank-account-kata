package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.*;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckBalanceTest {

    private PastTransactionsRepository pastTransactionsRepository = mock(PastTransactionsRepository.class);
    private CheckBalance checkBalance = new CheckBalance(pastTransactionsRepository);

    @Test
    public void must_return_a_zero_balance_without_operation() {
        // Arrange
        givenAnAccountWithoutOperation();

        // Act
        Balance balance = checkBalance.getAccountBalance(new Account("1234567890123"));

        // Assert
        assertThat(balance.getValue()).isEqualTo(0);
    }

    @Test
    public void must_return_a_balance_with_the_amount_of_the_only_operation() {
        // Arrange
        givenAnAccountWithDeposits(new Amount(10000));
        givenAnAccountWithWithdrawal();

        // Act
        Balance balance = checkBalance.getAccountBalance(new Account("1234567890123"));

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000);
    }

    @Test
    public void must_return_a_balance_with_the_sum_of_the_deposits() {
        // Arrange
        givenAnAccountWithDeposits(new Amount(10000),new Amount(20000),new Amount(15000));
        givenAnAccountWithWithdrawal();

        // Act
        Balance balance = checkBalance.getAccountBalance(new Account("1234567890123"));

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000 + 20000 + 15000);
    }

    @Test
    public void must_return_a_balance_with_the_sum_of_the_operations() {
        // Arrange
        givenAnAccountWithDeposits(new Amount(10000),new Amount(20000),new Amount(15000));
        givenAnAccountWithWithdrawal(new Amount(10000),new Amount(10000));

        // Act
        Balance balance = checkBalance.getAccountBalance(new Account("1234567890123"));

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000 + 20000 + 15000 - 10000 - 10000);
    }

    private void givenAnAccountWithWithdrawal(Amount... amounts) {
        when(pastTransactionsRepository.getWithdrawalAmounts(any())).thenReturn(Amounts.of(Arrays.asList(amounts)));
    }

    private void givenAnAccountWithDeposits(Amount... amounts) {
        when(pastTransactionsRepository.getDepositAmounts(any())).thenReturn(Amounts.of(Arrays.asList(amounts)));
    }

    private void givenAnAccountWithoutOperation() {
        when(pastTransactionsRepository.getDepositAmounts(any())).thenReturn(Amounts.of(null));
        when(pastTransactionsRepository.getWithdrawalAmounts(any())).thenReturn(Amounts.of(null));
    }
}
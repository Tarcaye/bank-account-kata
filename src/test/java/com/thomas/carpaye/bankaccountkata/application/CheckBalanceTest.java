package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.Amounts;
import com.thomas.carpaye.bankaccountkata.domain.model.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckBalanceTest {

    private DepositRepository depositRepository = mock(DepositRepository.class);
    private CheckBalance checkBalance = new CheckBalance(depositRepository);

    @Test
    public void must_return_a_zero_balance_without_operation() {
        // Arrange
        givenAnAccountWithoutOperation();

        // Act
        Balance balance = checkBalance.getAccountBalance("1234567890123");

        // Assert
        assertThat(balance.getValue()).isEqualTo(0);
    }

    @Test
    public void must_return_a_balance_with_the_amount_of_the_only_operation() {
        // Arrange
        givenAnAccountWithDeposits(new Amount(10000));

        // Act
        Balance balance = checkBalance.getAccountBalance("1234567890123");

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000);
    }

    private void givenAnAccountWithDeposits(Amount... amounts) {
        when(depositRepository.getDepositAmounts(any())).thenReturn(Amounts.of(Arrays.asList(amounts)));
    }

    @Test
    public void must_return_a_balance_with_the_sum_of_the_operations() {
        // Arrange
        givenAnAccountWithDeposits(new Amount(10000),new Amount(20000),new Amount(15000));

        // Act
        Balance balance = checkBalance.getAccountBalance("1234567890123");

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000 + 20000 + 15000);
    }

    private void givenAnAccountWithoutOperation() {
        when(depositRepository.getDepositAmounts(any())).thenReturn(Amounts.of(null));
    }
}
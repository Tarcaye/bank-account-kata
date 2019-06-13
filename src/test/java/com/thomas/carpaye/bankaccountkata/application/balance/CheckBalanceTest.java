package com.thomas.carpaye.bankaccountkata.application.balance;

import com.thomas.carpaye.bankaccountkata.domain.model.balance.OperationsRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckBalanceTest {

    private OperationsRepository operationsRepository = mock(OperationsRepository.class);
    private CheckBalance checkBalance = new CheckBalance(operationsRepository);

    @Test
    public void must_return_an_account_balance() {
        // Arrange
        String accountId = "1234567890123";
        when(operationsRepository.getBalance(eq(Account.of(accountId)))).thenReturn(new Balance(1000));

        // Act
        Balance balance = checkBalance.getAccountBalance(new CheckBalanceQuery(accountId));

        // Assert
        assertThat(balance.getValue()).isEqualTo(1000);
    }
}
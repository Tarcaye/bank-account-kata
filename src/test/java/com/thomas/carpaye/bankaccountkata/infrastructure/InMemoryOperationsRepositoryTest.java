package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.Withdrawal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryOperationsRepositoryTest {

    private InMemoryOperationsRepository operationsRepository;

    @Before
    public void setUp() throws Exception {
        operationsRepository = new InMemoryOperationsRepository();
    }

    @Test
    public void must_return_a_zero_balance_without_operation() {
        // Arrange
        Account account = Account.of("1234567890123");

        // Act
        Balance balance = operationsRepository.getBalance(account);

        // Assert
        assertThat(balance.getValue()).isEqualTo(0);
    }

    @Test
    public void must_return_a_balance_with_the_amount_of_the_only_operation() {
        // Arrange
        Account account = Account.of("1234567890123");
        operationsRepository.add(account, Deposit.of(new Amount(10000)));

        // Act
        Balance balance = operationsRepository.getBalance(account);

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000);
    }

    @Test
    public void must_return_a_balance_with_the_sum_of_the_deposits() {
        // Arrange
        Account account = Account.of("1234567890123");
        operationsRepository.add(account, Deposit.of(new Amount(10000)));
        operationsRepository.add(account, Deposit.of(new Amount(20000)));
        operationsRepository.add(account, Deposit.of(new Amount(15000)));

        // Act
        Balance balance = operationsRepository.getBalance(account);

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000 + 20000 + 15000);
    }

    @Test
    public void must_return_a_balance_with_the_sum_of_the_operations() {
        // Arrange
        Account account = Account.of("1234567890123");
        operationsRepository.add(account, Deposit.of(new Amount(10000)));
        operationsRepository.add(account, Deposit.of(new Amount(20000)));
        operationsRepository.add(account, Deposit.of(new Amount(15000)));
        operationsRepository.add(account, Withdrawal.of(new Amount(10000)));
        operationsRepository.add(account, Withdrawal.of(new Amount(10000)));

        // Act
        Balance balance = operationsRepository.getBalance(account);

        // Assert
        assertThat(balance.getValue()).isEqualTo(10000 + 20000 + 15000 - 10000 - 10000);
    }
}
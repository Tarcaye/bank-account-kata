package com.thomas.carpaye.bankaccountkata.application.deposit;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.OperationsRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class SaveMoneyTest {

    private OperationsRepository operationsRepository = Mockito.mock(OperationsRepository.class);
    private SaveMoney saveMoney = new SaveMoney(operationsRepository);

    @Test
    public void must_save_money_deposit(){
        // Arrange
        int money = 10;
        String accountId = "1234567890123";

        // Act
        saveMoney.save(new SaveMoneyCommand(accountId, money));

        // Assert
        Mockito.verify(operationsRepository).add(eq(Account.of(accountId)), any());
    }

}
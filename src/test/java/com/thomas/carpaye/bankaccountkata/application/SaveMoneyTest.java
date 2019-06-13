package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.PastTransactionsRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class SaveMoneyTest {

    private PastTransactionsRepository pastTransactionsRepository = Mockito.mock(PastTransactionsRepository.class);
    private SaveMoney saveMoney = new SaveMoney(pastTransactionsRepository);

    @Test
    public void must_save_money_deposit(){
        // Arrange
        int money = 10;
        String accountId = "1234567890123";

        // Act
        saveMoney.save(accountId, money);


        // Assert
        Mockito.verify(pastTransactionsRepository).add(any(Account.class), any(Deposit.class));
    }

}
package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class SaveMoneyTest {

    private DepositRepository depositRepository = Mockito.mock(DepositRepository.class);
    private SaveMoney saveMoney = new SaveMoney(depositRepository);

    @Test
    public void must_save_money_deposit(){
        // Arrange
        int money = 10;
        String accountId = "1234567890123";

        // Act
        saveMoney.save(accountId, money);


        // Assert
        Mockito.verify(depositRepository).add(any());
    }

}
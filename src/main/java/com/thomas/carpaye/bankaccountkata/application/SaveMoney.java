package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;

public class SaveMoney {
    private final DepositRepository depositRepository;

    public SaveMoney(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public void save(String accountId, int money) {
        depositRepository.add(Deposit.of(accountId, money));
    }
}

package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.PastTransactionsRepository;

public class SaveMoney {
    private final PastTransactionsRepository pastTransactionsRepository;

    public SaveMoney(PastTransactionsRepository pastTransactionsRepository) {
        this.pastTransactionsRepository = pastTransactionsRepository;
    }

    public void save(String accountId, int money) {
        pastTransactionsRepository.add(Deposit.of(accountId, money));
    }
}

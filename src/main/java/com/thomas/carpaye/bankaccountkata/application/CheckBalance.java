package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Amounts;
import com.thomas.carpaye.bankaccountkata.domain.model.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;

public class CheckBalance {

    private final DepositRepository depositRepository;

    public CheckBalance(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public Balance getAccountBalance(String accountId) {
        Amounts depositAmounts = depositRepository.getDepositAmounts(new Account(accountId));
        return new Balance(depositAmounts.getSum());
    }

}

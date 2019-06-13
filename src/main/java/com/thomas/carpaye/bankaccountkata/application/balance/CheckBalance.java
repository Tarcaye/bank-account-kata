package com.thomas.carpaye.bankaccountkata.application.balance;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.balance.OperationsRepository;

public class CheckBalance {

    private final OperationsRepository operationsRepository;

    public CheckBalance(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    public Balance getAccountBalance(CheckBalanceQuery checkBalanceQuery) {
        Account account = Account.of(checkBalanceQuery.getAccountId());
        return operationsRepository.getBalance(account);
    }

}

package com.thomas.carpaye.bankaccountkata.application.deposit;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.OperationsRepository;

public class SaveMoney {
    private final OperationsRepository operationsRepository;

    public SaveMoney(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    public void save(SaveMoneyCommand saveMoneyCommand) {
        Account account = Account.of(saveMoneyCommand.getAccountId());
        Amount amount = new Amount(saveMoneyCommand.getMoney());

        operationsRepository.add(account, Deposit.of(amount));
    }
}

package com.thomas.carpaye.bankaccountkata.application.withdrawal;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.InsufficientFundsException;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OperationsRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OverdraftRepository;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.Withdrawal;

public class WithdrawMoney {

    private final OperationsRepository operationsRepository;
    private final OverdraftRepository overdraftRepository;

    public WithdrawMoney(OperationsRepository operationsRepository, OverdraftRepository overdraftRepository) {
        this.operationsRepository = operationsRepository;
        this.overdraftRepository = overdraftRepository;
    }

    public void withdraw(WithdrawMoneyCommand withdrawMoneyCommand) {
        final Account account = new Account(withdrawMoneyCommand.getAccountId());
        Amount overdraft = overdraftRepository.getOverdraft(account);
        Amount amount = new Amount(withdrawMoneyCommand.getMoney());
        Withdrawal withdrawal = Withdrawal.of(amount);
        Balance newBalance = operationsRepository.getBalance(account).add(withdrawal);

        if (newBalance.insufficientFunds(overdraft)) {
            throw new InsufficientFundsException("Insufficient funds for withdraw : " + withdrawal + " on account : " + account);
        }

        operationsRepository.add(account, withdrawal);
    }

}

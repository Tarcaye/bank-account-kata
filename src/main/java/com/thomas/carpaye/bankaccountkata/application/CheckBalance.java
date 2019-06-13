package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Amounts;
import com.thomas.carpaye.bankaccountkata.domain.model.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.PastTransactionsRepository;

public class CheckBalance {

    private final PastTransactionsRepository pastTransactionsRepository;

    public CheckBalance(PastTransactionsRepository pastTransactionsRepository) {
        this.pastTransactionsRepository = pastTransactionsRepository;
    }

    public Balance getAccountBalance(Account account) {
        Amounts depositAmounts = pastTransactionsRepository.getDepositAmounts(account);
        Amounts withdrawalAmounts = pastTransactionsRepository.getWithdrawalAmounts(account);
        return new Balance(depositAmounts.getSum() - withdrawalAmounts.getSum());
    }

}

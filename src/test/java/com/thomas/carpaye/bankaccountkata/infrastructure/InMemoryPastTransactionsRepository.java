package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.*;

import java.util.*;

public class InMemoryPastTransactionsRepository implements PastTransactionsRepository {

    private Map<Account, List<Amount>> depositByAccount = new HashMap<>();
    private Map<Account, List<Amount>> withdrawalByAccount = new HashMap<>();

    @Override
    public void add(Account account, Deposit deposit) {
        add(account, depositByAccount, deposit);
    }

    @Override
    public void add(Account account, Withdrawal withdrawal) {
        add(account, withdrawalByAccount, withdrawal);
    }

    private void add(Account account, Map<Account, List<Amount>> operationsByAccount, PastTransaction pastTransaction) {
        List<Amount> amounts = getAmounts(account, operationsByAccount);
        amounts.add(pastTransaction.getAmount());
        operationsByAccount.put(account, amounts);
    }

    private List<Amount> getAmounts(Account account, Map<Account, List<Amount>> operationsByAccount) {
        List<Amount> amounts = operationsByAccount.get(account);
        if (amounts == null){
            amounts = new ArrayList<>();
        }
        return amounts;
    }

    @Override
    public Amounts getDepositAmounts(Account account) {
        return Amounts.of(depositByAccount.get(account));
    }

    @Override
    public Amounts getWithdrawalAmounts(Account account) {
        return Amounts.of(withdrawalByAccount.get(account));
    }
}

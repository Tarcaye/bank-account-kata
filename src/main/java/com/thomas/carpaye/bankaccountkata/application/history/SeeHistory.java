package com.thomas.carpaye.bankaccountkata.application.history;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.history.History;
import com.thomas.carpaye.bankaccountkata.domain.model.history.OperationsRepository;

public class SeeHistory {
    private final OperationsRepository operationsRepository;

    public SeeHistory(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    public History of(SeeHistoryQuery seeHistoryQuery) {
        Account account = Account.of(seeHistoryQuery.getAccountId());
        return operationsRepository.getHistory(account);
    }
}

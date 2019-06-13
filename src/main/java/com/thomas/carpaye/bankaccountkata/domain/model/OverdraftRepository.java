package com.thomas.carpaye.bankaccountkata.domain.model;

public interface OverdraftRepository {
    Amount getOverdraft(Account account);
}

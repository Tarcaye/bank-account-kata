package com.thomas.carpaye.bankaccountkata.domain.model;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

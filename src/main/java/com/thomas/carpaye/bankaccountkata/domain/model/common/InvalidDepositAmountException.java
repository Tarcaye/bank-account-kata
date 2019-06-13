package com.thomas.carpaye.bankaccountkata.domain.model.common;

public class InvalidDepositAmountException extends RuntimeException {

    public InvalidDepositAmountException(String message) {
        super(message);
    }
}

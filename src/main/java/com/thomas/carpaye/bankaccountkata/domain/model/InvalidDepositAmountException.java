package com.thomas.carpaye.bankaccountkata.domain.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class InvalidDepositAmountException extends RuntimeException {

    public InvalidDepositAmountException(String message) {
        super(message);
    }
}

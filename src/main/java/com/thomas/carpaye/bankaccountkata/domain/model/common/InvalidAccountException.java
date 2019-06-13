package com.thomas.carpaye.bankaccountkata.domain.model.common;

public class InvalidAccountException extends RuntimeException {

    public InvalidAccountException(String message) {
        super(message);
    }
}
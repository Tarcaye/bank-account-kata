package com.thomas.carpaye.bankaccountkata.domain.model.common;

public class Amount {
    final int value;

    public Amount(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    public int getValue() {
        return value;
    }

    public boolean isNegative() {
        return this.value <=0;
    }
}

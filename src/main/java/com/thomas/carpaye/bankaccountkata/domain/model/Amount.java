package com.thomas.carpaye.bankaccountkata.domain.model;

public class Amount {
    final int value;

    public Amount(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }
}

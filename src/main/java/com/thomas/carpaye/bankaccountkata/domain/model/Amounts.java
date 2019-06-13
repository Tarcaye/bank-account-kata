package com.thomas.carpaye.bankaccountkata.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Amounts {

    private final List<Amount> amountList;

    private Amounts(List<Amount> amountList) {
        this.amountList = amountList;
    }

    public static Amounts of(List<Amount> amountList) {
        if (amountList==null){
            return new Amounts(Collections.emptyList());
        }
        return new Amounts(Collections.unmodifiableList(amountList));
    }

    public int getSum() {
        return amountList.stream().map(amount -> amount.value)
                .collect(Collectors.summingInt(i -> i));
    }
}

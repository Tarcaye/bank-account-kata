package com.thomas.carpaye.bankaccountkata.domain.model.history;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class History {

    private final List<Operation> operations;

    private History(List<Operation> operations) {
        this.operations = operations;
    }

    public static History of(List<Operation> operations) {
        return new History(Collections.unmodifiableList(operations));
    }

    @Override
    public String toString() {
        return operations.stream()
                .map(Operation::toString)
                .collect(Collectors.joining("\n"));
    }
}

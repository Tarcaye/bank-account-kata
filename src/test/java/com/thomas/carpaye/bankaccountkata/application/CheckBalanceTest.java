package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckBalanceTest {

    private DepositRepository depositRepository = mock(DepositRepository.class);

    @Test
    public void must_return_an_empty_balance_without_operation() {
        when(depositRepository.getDeposits(any())).thenReturn(Collections.emptyList());
    }
}
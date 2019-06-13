package com.thomas.carpaye.bankaccountkata.domain.model;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.InvalidAccountException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    @Test
    public void cannot_create_an_account_without_id() {
        // Arrange
        String accountId = null;

        // Act
        assertThatThrownBy(()-> Account.of(accountId))
        // Assert
        .isExactlyInstanceOf(InvalidAccountException.class)
        .hasMessage("Invalid accountId : " + accountId);
    }


}
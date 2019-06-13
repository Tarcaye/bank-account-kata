package com.thomas.carpaye.bankaccountkata.application.history;

import com.thomas.carpaye.bankaccountkata.application.balance.CheckBalance;
import com.thomas.carpaye.bankaccountkata.application.deposit.SaveMoney;
import com.thomas.carpaye.bankaccountkata.application.deposit.SaveMoneyCommand;
import com.thomas.carpaye.bankaccountkata.application.withdrawal.WithdrawMoney;
import com.thomas.carpaye.bankaccountkata.application.withdrawal.WithdrawMoneyCommand;
import com.thomas.carpaye.bankaccountkata.domain.model.history.History;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OverdraftRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.InMemoryOperationsRepository;
import com.thomas.carpaye.bankaccountkata.infrastructure.SimpleOverdraftRepository;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class SeeHistoryIntegrationTest {

    private InMemoryOperationsRepository operationsRepository = new InMemoryOperationsRepository();

    private SaveMoney saveMoney = new SaveMoney(operationsRepository);
    private CheckBalance checkBalance = new CheckBalance(operationsRepository);

    private OverdraftRepository overdraftRepository = new SimpleOverdraftRepository();
    private WithdrawMoney withdrawMoney = new WithdrawMoney(operationsRepository, overdraftRepository);
    private SeeHistory seeHistory = new SeeHistory(operationsRepository);
    private String todaysDate = LocalDate.now().toString();

    @Test
    public void must_return_history_from_bank_account_with_a_single_operation() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(new SaveMoneyCommand(accountId, 1200000));

        // Act
        History history = seeHistory.of(new SeeHistoryQuery(accountId));

        // Assert
        assertThat(history.toString()).isEqualTo("DEPOSIT | 2019-06-13 | 1200000 | 1200000");
    }

    @Test
    public void must_return_history_from_bank_account_with_multiple_operations() {
        // Arrange
        String accountId = "1234567890123";
        saveMoney.save(new SaveMoneyCommand(accountId, 1200000));
        saveMoney.save(new SaveMoneyCommand(accountId, 11000));
        withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, 3000));
        saveMoney.save(new SaveMoneyCommand(accountId, 14000));
        saveMoney.save(new SaveMoneyCommand(accountId, 13000));
        withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, 14000));
        withdrawMoney.withdraw(new WithdrawMoneyCommand(accountId, 19000));
        saveMoney.save(new SaveMoneyCommand(accountId, 15000));

        // Act
        History history = seeHistory.of(new SeeHistoryQuery(accountId));

        // Assert
        assertThat(history.toString()).isEqualTo("DEPOSIT | 2019-06-13 | 1200000 | 1200000\n" +
                "DEPOSIT | 2019-06-13 | 11000 | 1211000\n" +
                "WITHDRAWAL | 2019-06-13 | -3000 | 1208000\n" +
                "DEPOSIT | 2019-06-13 | 14000 | 1222000\n" +
                "DEPOSIT | 2019-06-13 | 13000 | 1235000\n" +
                "WITHDRAWAL | 2019-06-13 | -14000 | 1221000\n" +
                "WITHDRAWAL | 2019-06-13 | -19000 | 1202000\n" +
                "DEPOSIT | 2019-06-13 | 15000 | 1217000");
    }

}

package bank;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static bank.Amount.createAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {





    @Test
    void the_balance_of_a_new_bank_acount_is_zero() {
        Account account = new Account(new Client(123456));

        Amount balance = account.getBalance();

        assertThat(balance).isEqualTo(createAmount(0));
    }

    @Test
    void the_balance_of_a_bank_acount_after_a_single_deposit_is_the_amount_of_the_deposit() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(100), createDate("2012-07-10 14:58:00"));

        assertThat(account.getBalance()).isEqualTo(createAmount(100));
    }

    private Date createDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void the_balance_of_a_bank_acount_after_two_deposits_is_the_sum_of_the_deposits() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(100), createDate("2012-07-10 14:58:00"));
        account.deposit(createAmount(100), createDate("2012-07-10 14:58:00"));

        assertThat(account.getBalance()).isEqualTo(createAmount(100 + 100));
    }

    @Test
    void a_customer_should_withdraw_all_his_savings() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(1000), createDate("2012-07-10 14:58:00"));
        account.withdraw(createAmount(1000), createDate("2012-07-11 15:58:00"));

        assertThat(account.getBalance()).isEqualTo(createAmount(1000 - 1000));
    }


    @Test
    void a_customer_should_withdraw_some_of_his_savings() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(1000), createDate("2012-07-10 14:58:00"));
        account.withdraw(createAmount(100), createDate("2012-07-11 15:58:00"));

        assertThat(account.getBalance()).isEqualTo(createAmount(1000 - 100));
    }


    @Test
    void a_customer_cannot_withdraw_more_than_his_savings() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(1000), createDate("2012-07-10 14:58:00"));
        assertThatThrownBy(() -> account.withdraw(createAmount(10000), createDate("2012-07-11 15:58:00")))
                .isInstanceOf(UnsupportedWithdrawalException.class)
                .hasMessage("Unable to withdraw this amount : Client: 123456, balance: 1000, withdrawal: 10000");
    }

    @Test
    void a_new_account_has_no_history() {
        Account account = new Account(new Client(123456));

        History history = account.history();

        assertThat(history.asStrings()).isEmpty();
    }

    @Test
    void a_client_should_see_a_deposit_in_his_history() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(1000), createDate("2012-07-10 14:58:00"));
        History history = account.history();

        assertThat(history.asStrings()).contains("Operation : {type: Deposit, date: 2012-07-10 14:58:00, amount: 1000, balance: 1000}");
    }


    @Test
    void a_client_should_see_a_withdraw_in_his_history() {
        Account account = new Account(new Client(123456));

        account.deposit(createAmount(1000), createDate("2012-07-10 14:58:00"));
        account.withdraw(createAmount(700), createDate("2012-07-11 15:58:00"));
        History history = account.history();

        assertThat(history.asStrings()).contains("Operation : {type: Deposit, date: 2012-07-10 14:58:00, amount: 1000, balance: 1000}","Operation : {type: Withdraw, date: 2012-07-11 15:58:00, amount: 700, balance: 300}");
    }


}

package bank;

import org.junit.jupiter.api.Test;

import static bank.Amount.createAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    @Test
    void the_balance_of_a_new_bank_acount_is_zero() {
        Account account = new Account(new Client());

        Amount balance = account.getBalance();

        assertThat(balance).isEqualTo(createAmount(0));
    }

    @Test
    void the_balance_of_a_bank_acount_after_a_single_deposit_is_the_amount_of_the_deposit() {
        Account account = new Account(new Client());

        account.deposit(createAmount(100));

        assertThat(account.getBalance()).isEqualTo(createAmount(100));
    }

    @Test
    void the_balance_of_a_bank_acount_after_two_deposits_is_the_sum_of_the_deposits() {
        Account account = new Account(new Client());

        account.deposit(createAmount(100));
        account.deposit(createAmount(100));

        assertThat(account.getBalance()).isEqualTo(createAmount(100 + 100));
    }

    @Test
    void a_customer_should_withdraw_all_his_savings() {
        Account account = new Account(new Client());

        account.deposit(createAmount(1000));
        account.withdraw(createAmount(1000));

        assertThat(account.getBalance()).isEqualTo(createAmount(1000 - 1000));
    }


    @Test
    void a_customer_should_withdraw_some_of_his_savings() {
        Account account = new Account(new Client());

        account.deposit(createAmount(1000));
        account.withdraw(createAmount(100));

        assertThat(account.getBalance()).isEqualTo(createAmount(1000 - 100));
    }



    @Test
    void a_customer_cannot_withdraw_more_than_his_savings() {
        Account account = new Account(new Client());

        account.deposit(createAmount(1000));
        assertThatThrownBy(() -> account.withdraw(createAmount(10000)))
            .isInstanceOf(IllegalArgumentException.class);
    }





}

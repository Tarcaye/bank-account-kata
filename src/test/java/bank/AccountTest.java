package bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void the_balance_of_a_new_bank_acount_is_zero() {
        Account account = new Account(new Client());

        Amount balance = account.getBalance();

        assertThat(balance).isEqualTo(new Amount(0));
    }

    @Test
    void the_balance_of_a_bank_acount_after_a_single_deposit_is_the_amount_of_the_deposit() {
        Account account = new Account(new Client());

        account.deposit(new Amount(100));

        assertThat(account.getBalance()).isEqualTo(new Amount(100));
    }



    @Test
    void the_balance_of_a_bank_acount_after_two_deposits_is_the_sum_of_the_deposits() {
        Account account = new Account(new Client());

        account.deposit(new Amount(100));
        account.deposit(new Amount(100));

        assertThat(account.getBalance()).isEqualTo(new Amount(100 + 100));
    }


}

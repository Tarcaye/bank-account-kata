package bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SaveMoneyTest {

    @Test
    void save_money() {
        Account account = new Account(new Client());

        account.deposit(new Amount(100));

        assertThat(account.getBalance()).isEqualTo(new Amount(100));
    }

    @Test
    void the_balance_of_a_new_bank_acount_is_zero() {
        Account account = new Account(new Client());

        Amount balance = account.getBalance();

        assertThat(balance).isEqualTo(new Amount(0));
    }



}

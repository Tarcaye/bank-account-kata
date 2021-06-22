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



}

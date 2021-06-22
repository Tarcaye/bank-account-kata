package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaveMoneyTest {

    @Test
    void save_money() {
        Account account = new Account(new Client());

        Amount deposit = account.deposit(100);

        Assertions.assertThat(deposit.asLong()).isEqualTo(100);
    }



}

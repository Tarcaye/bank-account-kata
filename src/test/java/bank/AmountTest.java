package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    void an_amount_should_not_be_negative() {
        Assertions.assertThatThrownBy(()-> Amount.createAmount(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("An amount cannot be negative : -100 is not a valid amount");
    }
}

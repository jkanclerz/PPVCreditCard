package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SqlCreditCardStorageTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void itAllowStoreCreditCard() {
        SqlCreditCardStorage storage = new SqlCreditCardStorage(jdbcTemplate);

        CreditCard cc = new CreditCard("1234-5678");
        cc.assignLimit(BigDecimal.valueOf(1000));
        storage.add(cc);
        CreditCard loaded = storage.load("1234-5678");

        assertThat(loaded.cardNumber).isEqualTo(cc.cardNumber);
    }
}

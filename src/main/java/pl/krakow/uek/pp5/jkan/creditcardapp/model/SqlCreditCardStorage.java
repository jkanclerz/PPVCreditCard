package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SqlCreditCardStorage implements CreditCardStorage {
    private JdbcTemplate jdbcTemplate;

    public SqlCreditCardStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(CreditCard card) {
        jdbcTemplate.update(
                "INSERT INTO `cards` (`number`, `limit`, `saldo`) " +
                    "VALUES " +
                    "(?, ?, ?)",
                card.cardNumber,
                card.getLimit(),
                card.currentBalance()
        );
    }

    @Override
    public CreditCard load(String creditCardNumber) {
        CreditCardData data = jdbcTemplate.queryForObject(
                "Select * from `cards` WHERE number = ?",
                new Object[]{creditCardNumber},
                BeanPropertyRowMapper.newInstance(CreditCardData.class)
        );

        return CreditCard.of(data);
    }

    @Override
    public List<CreditCard> all() {
        return null;
    }
}

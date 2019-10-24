package pl.krakow.uek.pira.ppv.creditcatd.model;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
    private BigDecimal limit;
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getLimit() {
        return limit;
    }
}

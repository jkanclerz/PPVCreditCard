package pl.krakow.uek.pira.ppv.creditcatd.model;

import java.math.BigDecimal;

public class CreditCard {
    private String cardNumber;
    private BigDecimal limit;
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal limit) {
        if (BigDecimal.valueOf(100).compareTo(limit) == 1) {
            throw new creditBelowMinimumException();
        }
        this.limit = limit;
    }

    public BigDecimal getLimit() {
        return limit;
    }
}

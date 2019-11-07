package pl.krakow.uek.pira.ppv.creditcatd.model;

import java.math.BigDecimal;

class CreditCard {
    private String cardNumber;
    private BigDecimal limit;
    private BigDecimal balance;
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal limit) {
        if (BigDecimal.valueOf(100).compareTo(limit) == 1) {
            throw new creditBelowMinimumException();
        }
        this.limit = limit;
        balance = limit;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) == -1)  {
            throw new NotEnoughMoneyException();
        }
        balance = balance.subtract(money);
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public BigDecimal getCurrentBalance() {
        return balance;
    }
}

package pl.krakow.uek.pp5.jkan.banking.creditcard.model;

import pl.krakow.uek.pp5.jkan.banking.creditcard.model.exceptions.CreditBelowMinimumValueException;
import pl.krakow.uek.pp5.jkan.banking.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

class CreditCard {
    String cardNumber;
    private BigDecimal creditLimit;
    private String slogan;
    private BigDecimal cardBalance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static CreditCard of(CreditCardData data) {
        CreditCard cc = new CreditCard(data.number);
        cc.creditLimit = data.limit;
        cc.cardBalance = data.saldo;

        return cc;
    }

    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw new CreditBelowMinimumValueException();
        }

        creditLimit = newLimit;
        cardBalance = creditLimit;
    }

    public BigDecimal getLimit() {
        return creditLimit;
    }

    public void withdraw(BigDecimal money) {
        if (currentBalance().compareTo(money) == -1) {
            throw new NotEnoughMoneyException();
        }

        cardBalance = cardBalance.subtract(money);
    }

    public BigDecimal currentBalance() {
        return cardBalance;
    }
}
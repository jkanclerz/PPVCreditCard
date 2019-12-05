package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import java.math.BigDecimal;

public class CreditCardData {
    String number;
    BigDecimal limit;
    BigDecimal saldo;

    public CreditCardData() {};

    public CreditCardData(String number, BigDecimal limit, BigDecimal saldo) {
        this.number = number;
        this.limit = limit;
        this.saldo = saldo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

package pl.krakow.uek.pira.ppv.creditcatd.model;

public interface CreditCardStorage {
    void add(CreditCard card);
    CreditCard load(String creditCardNumber);
}

package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import java.util.List;

public interface CreditCardStorage {
    void add(CreditCard card);

    CreditCard load(String creditCardNumber);

    List<CreditCard> all();
}

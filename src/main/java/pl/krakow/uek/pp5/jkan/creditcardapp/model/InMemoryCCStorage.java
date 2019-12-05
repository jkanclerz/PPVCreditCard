package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryCCStorage implements CreditCardStorage {

    private ConcurrentHashMap<String, CreditCard> cards;

    InMemoryCCStorage() {
        cards = new ConcurrentHashMap<String, CreditCard>();
    }

    @Override
    public void add(CreditCard card) {
        cards.put(card.cardNumber, card);
    }

    @Override
    public CreditCard load(String creditCardNumber) {
        return cards.get(creditCardNumber);
    }

    @Override
    public List<CreditCard> all() {
        return cards.values().stream()
                .collect(Collectors.toList());
    }
}

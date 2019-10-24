package pl.krakow.uek.pira.ppv.creditcatd.model;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {
    private static final int CREDIT_CARD_LIMIT = 2000;
    @Test
    public void itAllowAssignLimitCreditCard() {
        //Arrange
        CreditCard card = new CreditCard("1234-5435");
        //Act
        card.assignLimit(BigDecimal.valueOf(CREDIT_CARD_LIMIT));
        //Assert //then //expect
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(CREDIT_CARD_LIMIT)));
    }
}

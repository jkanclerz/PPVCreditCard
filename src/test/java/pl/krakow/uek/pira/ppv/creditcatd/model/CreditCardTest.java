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
    @Test
    public void isVerifyMinimumCreditValue() {
        //Arrange
        CreditCard card = new CreditCard("23423423432");
        //Act
        card.assignLimit(BigDecimal.valueOf(CREDIT_CARD_LIMIT));
        //Assert
        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("Exception should be thrown");
        }
        catch (creditBelowMinimumException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void withdrawFromCard(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(500));
        card2.withdraw(BigDecimal.valueOf(100));
        Assert.assertEquals(BigDecimal.valueOf(500),card1.getCurrentBalance());
        Assert.assertEquals(BigDecimal.valueOf(900),card2.getCurrentBalance());
    }
    @Test(expected = NotEnoughMoneyException.class)
    public void denyWithdrawBelowCurrentBalance() {
        CreditCard card = new CreditCard("123456667");
        card.assignLimit(BigDecimal.valueOf(1000));
        card.assignLimit(BigDecimal.valueOf(600));
        card.assignLimit(BigDecimal.valueOf(400));
    }
}

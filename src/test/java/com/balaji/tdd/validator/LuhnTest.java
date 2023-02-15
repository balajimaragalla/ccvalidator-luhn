package com.balaji.tdd.validator;

import com.balaji.tdd.core.CreditCard;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LuhnTest {
    @Test
    public void testCreditCardNull() {
        CreditCard creditCard = new CreditCard(new StringBuffer("4111111111111111"));
        creditCard.setCreditCardNumber(null);

        Assert.assertTrue(creditCard.getCreditCardNumber() == null);
    }

    @Test
    public void testCreditCardEmpty() {
        CreditCard creditCard = new CreditCard(new StringBuffer(""));

        Assert.assertTrue(creditCard.getCreditCardNumber().toString().isEmpty());
    }

    @Test
    public void testCreditCardNotNull() {
        CreditCard creditCard = new CreditCard(new StringBuffer("4111111111111111"));

        Assert.assertNotNull(creditCard.getCreditCardNumber().length() > 0);
    }

    @Test
    public void testCreditCardLength() {
        StringBuffer creditCardNumber = new StringBuffer("4111111111111111");
        int expectedCreditCardNumberLength = creditCardNumber.length();
        CreditCard creditCard = new CreditCard(creditCardNumber);

        assertEquals(expectedCreditCardNumberLength, creditCard.getCreditCardLength());
    }

    @Test
    public void testParity() {
        StringBuffer creditCardNumber = new StringBuffer("4111111111111111");
        CreditCard creditCard = new CreditCard(creditCardNumber);
        int expectedCreditCardNumberParity = creditCard.getParity();

        assertEquals(expectedCreditCardNumberParity, creditCard.getParity());
    }

    @Test
    public void testLuhnAlgorithmIsValid() {
        StringBuffer creditCardNumber = new StringBuffer("4111111111111111");
        CreditCard creditCard = new CreditCard(creditCardNumber);
        assertTrue(creditCard.getCreditCardValidator().checkLuhnCCValidity(creditCard));
    }

    @Test
    public void testLuhnAlgorithmIsInvalid() {
        StringBuffer creditCardNumber = new StringBuffer("1111111111111111");
        CreditCard creditCard = new CreditCard(creditCardNumber);
        assertFalse(creditCard.getCreditCardValidator().checkLuhnCCValidity(creditCard));
    }

}
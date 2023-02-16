package com.balaji.tdd.core;

import com.balaji.tdd.validator.Luhn;

public class CreditCard {
    private StringBuffer creditCardNumber = null;
    private int creditCardLength = 0;
    private int parity = 0;
    private Luhn creditCardValidator = null;

    public CreditCard (StringBuffer creditCardNumber) {
        this.creditCardNumber = new StringBuffer(creditCardNumber);
        this.setCreditCardLength(creditCardNumber.length());
        this.setParity(this.getCreditCardLength());
        this.creditCardValidator = new Luhn(this);
    }

    public StringBuffer getCreditCardNumber () {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber (StringBuffer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCreditCardLength () {
        return this.creditCardLength;
    }

    private void setCreditCardLength (int creditCardLength) {
        this.creditCardLength = creditCardLength;
    }

    public int getParity () {
        return this.parity;
    }

    private void setParity (int creditCardLength) {
        try {
            this.parity = creditCardLength % 2;
        } catch (ArithmeticException e) {
            System.out.println(
                "Index out of size of the array");
        }
    }

    public Luhn getCreditCardValidator () {
        return this.creditCardValidator;
    }
}

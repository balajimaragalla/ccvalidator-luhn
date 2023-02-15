package com.balaji.tdd.example;

import com.balaji.tdd.core.CreditCard;

import java.util.Arrays;
import java.util.List;

public class ValidateCreditCard {
    public static void main(String[] args){
		String creditCards[] = {"4111111111111111", "1111111111111111"};

		StringBuffer creditCardsBuffer[] = new StringBuffer[creditCards.length];
        for (int i = 0; i < creditCards.length; i++) {
            creditCardsBuffer[i] = new StringBuffer(creditCards[i]);
        }


        List<StringBuffer> creditCardsList = Arrays.asList(creditCardsBuffer);

    	System.out.println("Validating Credit Card number with Luhn Algorithm:");
        creditCardsList.stream().forEach(creditCard -> {
            CreditCard creditCardInstance = new CreditCard(creditCard);
            boolean isValid = creditCardInstance.getCreditCardValidator().checkLuhnCCValidity(creditCardInstance);
            System.out.println("Credit Card: " + creditCard + " is " + ( (isValid) ? "valid" : "not valid"));
        });
	}
}

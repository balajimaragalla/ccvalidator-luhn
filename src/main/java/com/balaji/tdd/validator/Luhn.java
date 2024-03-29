package com.balaji.tdd.validator;

import com.balaji.tdd.core.CreditCard;

public class Luhn {
	private int sum = 0;
	CreditCard creditCard = null;

	public Luhn (CreditCard creditCard) {
		this.creditCard = creditCard;
	}

    public int doubleIfParity (int index, int digit) {
        try {
    	if (index % 2 == creditCard.getParity()) {
    			digit = digit * 2;
    	}
    	    return digit;
            }
        catch (ArithmeticException e) {
            System.out.println(
                "Index out of size of the array");
            return digit;
        }
    }

    public int adjustDigitIfGreaterThanNine (int digit) {
    	if (digit > 9) {
    			digit = digit - 9;
    	}
    	return digit;
    }

    public boolean checkLuhnCCValidity (CreditCard creditCard) {
    	boolean isValid = false;

		if (creditCard.getCreditCardNumber().length() <= 0) {
			return isValid;
		}

		for (int i=0; i < creditCard.getCreditCardLength() ; i++) {
            int digit = Character.getNumericValue(creditCard.getCreditCardNumber().charAt(i));

            digit = adjustDigitIfGreaterThanNine(doubleIfParity(i, digit));

            sum = sum + digit;
        }

		isValid = (sum % 10) == 0;

		return isValid;

	}
}

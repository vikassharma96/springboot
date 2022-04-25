package com.example.restservice;

class CreditCard {
    String name;
    String creditCardNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

    @Override
    public String toString() {
        return "CreditCard [creditCardNumber=" + creditCardNumber + ", name=" + name + "]";
    };
}
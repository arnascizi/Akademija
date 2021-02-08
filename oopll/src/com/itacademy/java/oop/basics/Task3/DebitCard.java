package com.itacademy.java.oop.basics.Task3;

public class DebitCard extends Card {


    public DebitCard(double balance, String cardHolderName, String cardNumber) {
        super(balance, cardHolderName, cardNumber);
    }

    @Override
    double credit() {
        return 0;
    }

    @Override
    double debit(double amount) {
        return 0;
    }
}

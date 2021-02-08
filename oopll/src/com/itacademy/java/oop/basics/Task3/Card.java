package com.itacademy.java.oop.basics.Task3;

public abstract class Card {

    private double balance;
    private String cardHolderName;
    private String cardNumber;

    public Card(double balance, String cardHolderName, String cardNumber) {
        this.balance = balance;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    abstract double credit();

    abstract double debit(double amount);
}

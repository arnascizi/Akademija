package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughBalanceException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public abstract class Card {

    protected double balance;
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

    abstract void credit(double amount) throws NotEnoughCreditException, NotEnoughBalanceException;

    abstract void debit(double amount) throws NotEnoughCreditException, NotEnoughBalanceException;
}

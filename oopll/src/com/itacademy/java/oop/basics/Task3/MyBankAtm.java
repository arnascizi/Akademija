package com.itacademy.java.oop.basics.Task3;

public class MyBankAtm implements Atm {

    private double balance;

    public MyBankAtm(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(CreditCard creditCard, int amount) {

    }

    @Override
    public void withdraw(DebitCard debitCard, int amount) {

    }
}

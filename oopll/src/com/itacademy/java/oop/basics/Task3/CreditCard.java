package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public class CreditCard extends Card {

    private double interest;
    private double credit;

    public CreditCard(double interest, double credit, double balance, String cardHolerName, String cardNumber) {
        super(balance, cardHolerName, cardNumber);
        this.interest = interest;
        this.credit = credit;
    }

    public double getInterest() {
        return interest;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    void credit(double amount) throws NotEnoughCreditException {
        if (amount > getCredit() || Math.abs(getBalance() - amount) > getCredit()) {
            throw new NotEnoughCreditException("You have reached your credit limit! ");
        } else {
            balance -= amount;
            System.out.println("You have credited: " + amount);
        }
    }

    @Override
    void debit(double amount) throws NotEnoughCreditException {
        if (amount > getBalance() && getBalance() < 0) {
            credit(amount);
        } else {
            balance -= amount;
        }
    }
}

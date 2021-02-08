package com.itacademy.java.oop.basics.Task3;

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
    double credit() {
        return 0;
    }

    @Override
    double debit(double amount) {
        return 0;
    }

    
}

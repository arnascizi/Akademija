package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.InsufficientAtmFundsException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughBalanceException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public class MyBankAtm implements Atm {

    private double balance;

    public MyBankAtm(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(CreditCard creditCard, int amount) throws InsufficientAtmFundsException, NotEnoughCreditException {
        double withdrawAmount = amount + ((creditCard.getInterest() * amount) / 100);
        if (amount > this.balance) {
            throw new InsufficientAtmFundsException("The ATM does not have enough money!");
        } else {
            creditCard.debit(withdrawAmount);
            this.balance -= amount;
            System.out.println("You have withdrawn: " + amount + ". Transaction fee: " + (withdrawAmount - amount));
        }
    }

    @Override
    public void withdraw(DebitCard debitCard, int amount) throws InsufficientAtmFundsException, NotEnoughBalanceException {
        if (amount > this.balance) {
            throw new InsufficientAtmFundsException("The ATM does not have enough money!");
        } else {
            debitCard.debit(amount);
            this.balance -= amount;
            System.out.println("You have withdrawn: " + amount);
        }
    }
}

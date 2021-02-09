package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughBalanceException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public class DebitCard extends Card {


    public DebitCard(double balance, String cardHolderName, String cardNumber) {
        super(balance, cardHolderName, cardNumber);
    }

    @Override
    void credit(double amount) throws NotEnoughCreditException {
        throw new NotEnoughCreditException("You cannot credit your Debit Card!");
    }

    @Override
    void debit(double amount) throws NotEnoughBalanceException {
        if ((getBalance() - amount) < 0) {
            throw new NotEnoughBalanceException("Insufficient funds. You can't withdraw: " + amount +
                    ". You can withdraw: " + getBalance());
        } else {
            balance -= amount;
        }
    }
}

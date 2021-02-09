package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.InsufficientAtmFundsException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughBalanceException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public class AtmApplication {

    public static void main(String[] args) {
        MyBankAtm atm = new MyBankAtm(30000);
        CreditCard creditCard = new CreditCard(
                1,
                2000,
                1500,
                "John Doe",
                "AU68421231000315563");

        DebitCard debitCard = new DebitCard(
                1200,
                "Jane Doe",
                "AU68421231000315523");

        System.out.println("Credit card balance: " + creditCard.getBalance());
        System.out.println("Debit card balance: " + debitCard.getBalance());

        try {
            atm.withdraw(creditCard, 1500);
            atm.withdraw(creditCard, 1800);
            System.out.println("Your credit card balance: " + creditCard.getBalance());
            atm.withdraw(creditCard, 200);
        } catch (NotEnoughCreditException | InsufficientAtmFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            atm.withdraw(debitCard, 800);
            System.out.println("Your debit card balance: " + debitCard.getBalance());
            atm.withdraw(debitCard, 600);
        } catch (NotEnoughBalanceException | InsufficientAtmFundsException e) {
            System.out.println(e.getMessage());
        }

    }
}

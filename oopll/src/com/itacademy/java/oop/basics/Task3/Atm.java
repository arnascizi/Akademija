package com.itacademy.java.oop.basics.Task3;

public interface Atm {

    void withdraw(CreditCard creditCard, int amount);
    void withdraw(DebitCard debitCard, int amount);
}

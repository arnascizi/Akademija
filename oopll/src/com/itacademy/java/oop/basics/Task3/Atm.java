package com.itacademy.java.oop.basics.Task3;

import com.itacademy.java.oop.basics.Task3.exceptions.InsufficientAtmFundsException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughBalanceException;
import com.itacademy.java.oop.basics.Task3.exceptions.NotEnoughCreditException;

public interface Atm {

    void withdraw(CreditCard creditCard, int amount) throws InsufficientAtmFundsException, NotEnoughCreditException;

    void withdraw(DebitCard debitCard, int amount) throws InsufficientAtmFundsException, NotEnoughBalanceException;
}

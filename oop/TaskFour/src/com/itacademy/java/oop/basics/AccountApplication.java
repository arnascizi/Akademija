package com.itacademy.java.oop.basics;

public class AccountApplication {

    public static void main(String[] args) {
        Account firstAccount = new Account("1", "Joe", 100);
        Account secondAccount = new Account("2", "Jane", 50);

        firstAccount.credit(20);
        firstAccount.credit(10);
        System.out.println("Balance of the first account: " + firstAccount.getBalance());

        secondAccount.credit(10);
        System.out.println("Balance of the second account: " + secondAccount.getBalance());

        firstAccount.debit(500);
        secondAccount.transfertTo(firstAccount, 70);
        firstAccount.debit(30);
        System.out.println("Balance of the first account: " + firstAccount.getBalance());

        firstAccount.transfertTo(secondAccount, 10);
        System.out.println("Balance of the second account: " + secondAccount.getBalance());
        System.out.println("Balance of the first account: " + firstAccount.getBalance());

        System.out.println(firstAccount);
        System.out.println(secondAccount);
    }
}

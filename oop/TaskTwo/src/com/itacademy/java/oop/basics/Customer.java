package com.itacademy.java.oop.basics;

import java.util.Arrays;

public class Customer {

    private String name;
    private String surname;
    private int age;
    private long personalNumber;
    private Loan[] loan;

    public Customer() {
    }

    public Customer(String name, String surname, int age, long personalNumber, Loan[] loan) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personalNumber = personalNumber;
        this.loan = loan;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public Loan[] getLoan() {
        return loan;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", personalNumber=" + personalNumber +
                ", loan=" + Arrays.toString(loan) +
                '}';
    }
}

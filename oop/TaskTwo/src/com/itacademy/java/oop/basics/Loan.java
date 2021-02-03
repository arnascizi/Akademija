package com.itacademy.java.oop.basics;

public class Loan {

    private long id;
    private double amount;
    private LaonType laonType;
    private String terminationDate;

    public Loan(long id, double amount, LaonType laonType, String terminationDate) {
        this.id = id;
        this.amount = amount;
        this.laonType = laonType;
        this.terminationDate = terminationDate;
    }

    public Loan() {
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LaonType getLaonType() {
        return laonType;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", laonType=" + laonType.getDisplayLoan() +
                ", terminationDate='" + terminationDate + '\'' +
                '}';
    }
}

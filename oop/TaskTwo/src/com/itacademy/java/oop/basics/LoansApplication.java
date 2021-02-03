package com.itacademy.java.oop.basics;

public class LoansApplication {

    public static void main(String[] args) {
        Loan leasingLoan = new Loan(1234, 20000, LaonType.LEASING, "2028-12-18");
        Loan consumerLoan = new Loan(321, 1000, LaonType.CONSUMER, "2022-01-20");
        Loan[] loans = {leasingLoan, consumerLoan};
        Customer john = new Customer("John", "Doe", 30, 684975462, loans);
        System.out.println(john);
    }
}

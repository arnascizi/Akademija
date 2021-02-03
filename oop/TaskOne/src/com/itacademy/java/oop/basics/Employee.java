package com.itacademy.java.oop.basics;

import java.util.Date;

public class Employee {

    private String name;
    private String surname;
    private Contract contract;
    private Date startDate;
    private double salary;
    private String position;

    public Employee() {
    }

    public Employee(String name, String surname, Contract contract, Date startDate, double salary, String position) {
        this.name = name;
        this.surname = surname;
        this.contract = contract;
        this.startDate = startDate;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Contract getContract() {
        return contract;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contract=" + contract .getDisplayName() +
                ", startDate=" + startDate +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}

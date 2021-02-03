package com.itacademy.java.oop.basics;

import java.util.Date;

public class EmployeeManager {

    public static void main(String[] args) {

        Employee arnas = new Employee(
                "Arnas", "Čižikovas",
                Contract.FULL_TIME, new Date(),
                1000.00, "Junior Specialist"
        );

        System.out.println(arnas);
    }
}

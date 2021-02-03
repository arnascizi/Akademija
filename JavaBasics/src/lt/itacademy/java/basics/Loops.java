package lt.itacademy.java.basics;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter days: ");
        int days = sc.nextInt();
        calculateMinutes(days);
        whileCalculation(days);
        System.out.println("Enter number: ");
        int factorialNum = sc.nextInt();
        factorial(factorialNum);
    }

    private static void calculateMinutes(int days) {
        int hours = 0;
        int minutes = 0;
        for (int i = 0; i < days; i++) {
            hours = i * 24;
            minutes = i * 1440;
        }
        System.out.println("There are " + hours + " hours or " + minutes + " minutes in one year");
    }

    private static void whileCalculation(int days) {
        int hours = 0;
        int minutes = 0;
        int i = 0;
        while (i < days) {
            hours = i * 24;
            minutes = i * 1440;
            i++;
        }
        System.out.println("There are " + hours + " hours or " + minutes + " minutes in one year");
    }

    private static void factorial(int number) {
        int factorial = 1;
        for (int i = 1; i < number; i++) {
            factorial += factorial * i;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}

package lt.itacademy.java.basics;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Triangle");
        System.out.println("Rectangle");
        System.out.println("Square");
        System.out.println("Exit");
        System.out.println("------------------");
        String choice = sc.nextLine();
        switch (choice) {
            case "Triangle":
            case "triangle":
                calculateTriangle();
                calculator();
                break;
            case "Rectangle":
            case "rectangle":
                calculateRectangle();
                calculator();
                break;
            case "Square":
            case "square":
                calculateSquare();
                calculator();
                break;
            case "Exit":
            case "exit":
                System.exit(0);
                break;
            default:
                calculator();
                break;
        }
    }

    private static void calculateTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side A: ");
        int a = sc.nextInt();
        System.out.println("Enter side B: ");
        int b = sc.nextInt();
        System.out.println("Enter side C: ");
        int c = sc.nextInt();
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Triangle line value can't be 0");
            calculateTriangle();
        } else {
            System.out.println("Triangle perimeter is " +
                    perimeter(a, b, c) +
                    " and area is " +
                    area(a, b, c));
        }
    }

    private static void calculateRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side A: ");
        int a = sc.nextInt();
        System.out.println("Enter side B: ");
        int b = sc.nextInt();
        if (a <= 0 || b <= 0) {
            System.out.println("Rectangle line value can't be 0");
            calculateRectangle();
        } else {
            System.out.println("Rectangle perimeter is " +
                    perimeter(a, b) +
                    " and area is " +
                    area(a, b));
        }
    }

    private static void calculateSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side A: ");
        int a = sc.nextInt();
        if (a <= 0) {
            System.out.println("Square line value can't be 0");
            calculateSquare();
        } else {
            System.out.println("Square perimeter is " +
                    perimeter(a) +
                    " and area is " +
                    area(a));
        }
    }

    private static int perimeter(int a) {
        return a * 4;
    }

    private static int perimeter(int a, int b, int c) {
        return a + b + c;
    }

    private static int perimeter(int a, int b) {
        return (a + b) * 2;
    }

    private static double area(int a) {
        return Math.pow(a, 3);
    }

    private static double area(int a, int b) {
        return a * b;
    }

    private static double area(int a, int b, int c) {
        double p = (double) perimeter(a, b, c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

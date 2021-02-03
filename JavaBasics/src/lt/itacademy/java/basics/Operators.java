package lt.itacademy.java.basics;

import java.util.Scanner;

public class Operators {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side A: ");
        int sideA = sc.nextInt();
        System.out.println("Enter side B: ");
        int sideB = sc.nextInt();
        System.out.println("Enter side C: ");
        int sideC = sc.nextInt();
        System.out.println("Triangle is " + triangleCompare(sideA, sideB, sideC) +
                ". Sides: " + sideA + " " + sideB + " " + sideC + "");
        canItDrive(100, 6, 7, 1.25);
        canItDrive(110, 25, 7, 1.25);
    }

    private static String triangleCompare(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || c == a) {
            return "Isoceles";
        } else {
            return "Scalene";
        }
    }

    private static void canItDrive(int distance, int fuel, int fuelUsage, double fuelPrice) {
        double fuelNeeded = ((double) fuelUsage / 100) * distance;
        double litersOfFuel = Math.abs(fuelUsage - fuel);
        double fuelLeft = fuel - fuelUsage;
        if (fuelNeeded > fuel) {
            System.out.println("Destination is in " + distance + ". Car is not able to reach the destination. " +
                    "It needs " + litersOfFuel + "liter of fuel more. " +
                    "It will cost + " + litersOfFuel * fuelPrice + ".");
        } else if (fuelNeeded < fuel) {
            System.out.println("Destination is in " + distance + ". Car is able to reach the destination. " +
                    "It will have " + fuelLeft + " liters of fuel left.");
        }
    }
}

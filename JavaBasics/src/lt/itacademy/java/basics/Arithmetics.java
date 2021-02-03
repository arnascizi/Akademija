package lt.itacademy.java.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Arithmetics {

    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cube's value: ");
        int cubeValue = sc.nextInt();
        calculation(cubeValue);
        System.out.println("Enter feet: ");
        double feet = sc.nextDouble();
        System.out.println("Enter inches: ");
        double inch = sc.nextDouble();
        System.out.println(df.format(imperialToMetric(feet, inch)) + " cm");

    }

    private static void calculation(int value) {
        System.out.println((int) Math.pow(value, 3) + "cm3");
        System.out.println(12 * value + "cm");
    }

    private static double imperialToMetric(double feet, double inches) {
        double centimeter;
        centimeter = (feet * 12 + inches) * 2.54;
        return centimeter;
    }
}

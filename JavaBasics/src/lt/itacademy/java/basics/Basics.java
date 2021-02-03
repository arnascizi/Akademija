package lt.itacademy.java.basics;

import java.util.Scanner;

public class Basics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter surname: ");
        String surname = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Hello I am " + name +
                " " + surname +
                ", " + age +
                ". I am attending IT Academy 2021!");
        char letter = 'H';
        int num = 3110;
        String word = "w0r1d";
        float floatingNumber = 2.0F;
        boolean isItTrue = true;
        System.out.println(
                String.valueOf(letter) + num + " " +
                        word + " " +
                        floatingNumber + " " +
                        isItTrue);
        System.out.println("Enter first number: ");
        int x = sc.nextInt();
        System.out.println("Enter second number: ");
        int y = sc.nextInt();
        artihmeticOperations(x, y);
    }

    public static void artihmeticOperations(int x, int y) {
        System.out.println("sum of x and y: " + (x + y));
        System.out.println("difference of x and y: " + Math.abs(x - y));
        System.out.println("product of x and y: " + (x * y));
        System.out.println("multiple of x and y: " + (x * y));
        System.out.println("distance of x and y: " + Math.abs(x - y));
        System.out.println("maximum of x and y: " + Math.max(x, y));
        System.out.println("minimum of x and y: " + Math.min(x, y));
    }


}

package calculator;

import java.util.Scanner;

/**
 * A bit simplified version than the original
 */
public class Calculator {

    public static boolean parseExpression(String input) {
        input = input.trim();
        if (input.equalsIgnoreCase("quit")) {
            return false;
        } else {
            try {
                String[] expression = input.split(" ");
                if (expression.length != 3) {
                    System.out.println("Invalid Input");
                } else {
                    double op1 = Double.parseDouble(expression[0]);
                    char operation = expression[1].charAt(0);
                    double op2 = Double.parseDouble(expression[2]);
                    switch (operation) {
                        case '+':
                            System.out.printf("%.2f\n", op1 + op2);
                            break;
                        case '-':
                            System.out.printf("%.2f\n", op1 - op2);
                            break;
                        case '*':
                            System.out.printf("%.2f\n", op1 * op2);
                            break;
                        case '/':
                            System.out.printf("%.2f\n", op1 / op2);
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            return true;
        }
    }

    public static void readUserInput() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print(">");
            String input = sc.nextLine();
            loop = parseExpression(input);
        }
        sc.close();
        System.out.println("GoodBye!");
    }

    public static void main(String[] args) {
        readUserInput();
    }
}

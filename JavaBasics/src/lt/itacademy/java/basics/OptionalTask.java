package lt.itacademy.java.basics;

import java.util.Scanner;
import java.util.regex.Pattern;

public class OptionalTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        validate(password);
        System.out.println("Enter value x: ");
        String x = sc.nextLine();
        System.out.println("Enter value y: ");
        String y = sc.nextLine();
        calculateStringValues(x, y);
        String letters = "abcacabcacabcacabcacabcacabcacabcacabcac";
        System.out.println(characterRepeat(10, letters));

    }

    //Optional Task One
    private static void validate(String password) {
        String regex = "^[a-zA-Z0-9]+$";
        String numRegex = "(\\D*\\d){2,}";
        if (password.length() < 10) {
            System.out.println("Password must be at least 10 characters. " +
                    "Now it is: " + password.length() + " characters long");
        } else if (!Pattern.compile(regex).matcher(password).matches()) {
            System.out.println("Password must consist of only letters and digits");
        } else if (!Pattern.compile(numRegex).matcher(password).matches()) {
            System.out.println("Password must contain at least 2 digits");
        } else {
            System.out.println("Password is valid: " + password);
        }
    }

    //Optional Task Two
    private static long characterRepeat(int stringLenght, String letters) {
        String subLetters = letters.substring(0, stringLenght);
        return subLetters.chars().filter(ch -> ch == 'a').count();
    }

//    public class Optional {
//        public static void main(String[] args) {
//            long n = 1000000000000L;
//            String s = "a";
//            System.out.println(countLetter(n, s));
//        }
//        private static long countLetter(long n, String s) {
//            int result = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == 'a') {
//                    result++;
//                }
//            }
//            int tail = 0;
//            for (int i = 0; i < n % s.length(); i++) {
//                if (s.charAt(i) == 'a') {
//                    tail++;
//                }
//            }
//            result = (result * (n / s.length())) + tail;
//            return result;
//        }
//    }

    //Optional Task Three
    private static void calculateStringValues(String x, String y) {
        System.out.println(Integer.parseInt(x) + Integer.parseInt(y));
    }
}

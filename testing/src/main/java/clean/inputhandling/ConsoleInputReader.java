package clean.inputhandling;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readUserInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

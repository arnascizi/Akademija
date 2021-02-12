package clean.inputhandling;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Scanner;

import static org.testng.AssertJUnit.assertEquals;

public class ConsoleInputReaderTest {

    @Rule
    public final TextFromStandardInputStream systemInMock =
            TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void readUserInput() {
        systemInMock.provideText("DIVISION");
        Scanner sc = new Scanner(System.in);
        assertEquals("DIVISION", sc.nextLine());
    }
}
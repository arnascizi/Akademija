package clean.userinteraction;

import clean.inputhandling.InputReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SystemOutUserInteractorTest {

    @Mock
    private InputReader inputReader;

    @InjectMocks
    private SystemOutUserInteractor userInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void printsAndReturnsResult_whenTextProvided() throws Exception {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        when(inputReader.readUserInput()).thenReturn("User response");

        String response = userInteractor.writeAndGetResponse("Text to user");

        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertEquals(allWrittenLines.trim(), "Text to user");
    }
}

package clean.execution;

import clean.entities.CalculationOperations;
import clean.entities.CalculationStatement;
import clean.exceptions.InvalidInformationEnteredException;
import clean.operationconstrution.OperationConstructor;
import clean.userinteraction.UserInteractor;
import clean.userinteraction.UserTextPrinter;
import clean.userinteraction.resulthandling.CalculationResultsPrinter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;

public class LoopCalculationExecutorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private OperationConstructor operationConstructor;

    @Mock
    private UserInteractor userInteractor;

    @Mock
    private UserTextPrinter userTextPrinter;

    @Mock
    private CalculationResultsPrinter calculationResultsPrinter;

    @InjectMocks
    private LoopCalculationExecutor loopCalculationExecutor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeSingleOperation() throws Exception {
        CalculationStatement statement = new CalculationStatement(
                new BigDecimal(5),
                new BigDecimal(6),
                CalculationOperations.ADDITION
        );
        when(operationConstructor.fetchCalculationDetails())
                .thenReturn(statement);

        when(userInteractor.writeAndGetResponse(
                "Continue? Type TRUE for yes, FALSE - otherwise"))
                .thenReturn("false");

        loopCalculationExecutor.execute();

        assertEquals(new BigDecimal(11), statement.getResult().get());

        verify(calculationResultsPrinter).presentResults(statement);
    }

    @Test
    public void checkWhenBadInput() throws Exception {
        when(operationConstructor.fetchCalculationDetails())
                .thenThrow(new InvalidInformationEnteredException("Invalid Input 123"));

        when(userInteractor.writeAndGetResponse(
                "Continue? Type TRUE for yes, FALSE - otherwise"))
                .thenReturn("false");

        loopCalculationExecutor.execute();

        verify(userTextPrinter).write("Invalid Input 123");

        verify(calculationResultsPrinter, never()).presentResults(any(CalculationStatement.class));
    }

    @Test
    public void checkIfUserWantsToContinue() throws Exception {
        when(operationConstructor.fetchCalculationDetails())
                .thenReturn(
                        new CalculationStatement(
                                new BigDecimal(5),
                                new BigDecimal(6),
                                CalculationOperations.ADDITION
                        ));
        loopCalculationExecutor.execute();

        when(userInteractor.writeAndGetResponse(
                "Continue? Type TRUE for yes, FALSE - otherwise"))
                .thenReturn("false");

        loopCalculationExecutor.execute();

        verify(operationConstructor, times(2))
                .fetchCalculationDetails();
    }
}
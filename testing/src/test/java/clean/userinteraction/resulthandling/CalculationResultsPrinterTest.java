package clean.userinteraction.resulthandling;

import clean.entities.CalculationOperations;
import clean.entities.CalculationStatement;
import clean.exceptions.InvalidInformationEnteredException;
import clean.exceptions.ResultNotPresentException;
import clean.operationconstrution.OperationConstructor;
import clean.userinteraction.UserTextPrinter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationResultsPrinterTest {

    @Rule
    public ExpectedException expectedException =
            ExpectedException.none();

    @Mock
    private UserTextPrinter userTextPrinter;

    @Mock
    private CalculationStatement calculationStatement;

    @InjectMocks
    private CalculationResultsPrinter calculationResultsPrinter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkIfResultIsPresent() throws Exception {
        expectedException.expect(ResultNotPresentException.class);

        when(calculationStatement.getResult()).thenReturn(Optional.empty());
        calculationResultsPrinter.presentResults(calculationStatement);
    }

    @Test
    public void checkIfMessagePassed() throws Exception {
        CalculationStatement statement = new CalculationStatement(
                new BigDecimal(5),
                new BigDecimal(6),
                CalculationOperations.ADDITION
        );

        statement.setResult(Optional.of(new BigDecimal(11)));
        calculationResultsPrinter.presentResults(statement);
        verify(userTextPrinter).write("5 + 6 is 11");
    }
}
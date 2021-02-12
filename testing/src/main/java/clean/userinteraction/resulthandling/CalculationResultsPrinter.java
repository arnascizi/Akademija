package clean.userinteraction.resulthandling;

import clean.entities.CalculationStatement;
import clean.exceptions.ResultNotPresentException;
import clean.userinteraction.UserTextPrinter;

public class CalculationResultsPrinter {

    private UserTextPrinter userTextPrinter;

    public CalculationResultsPrinter(UserTextPrinter userTextPrinter) {
        this.userTextPrinter = userTextPrinter;
    }

    public void presentResults(CalculationStatement calculationStatement) throws Exception {
        if (!calculationStatement.getResult().isPresent()) {
            throw new ResultNotPresentException();
        }
        String message = String.format("%s %s %s is %s",
                calculationStatement.getFirstOperand(),
                calculationStatement.getOperation().getOperationSymbol(),
                calculationStatement.getSecondOperand(),
                calculationStatement.getResult().get());

        userTextPrinter.write(message);
    }
}

package clean.execution;

import clean.entities.CalculationStatement;
import clean.exceptions.InvalidInformationEnteredException;
import clean.operationconstrution.OperationConstructor;
import clean.userinteraction.UserInteractor;
import clean.userinteraction.UserTextPrinter;
import clean.userinteraction.resulthandling.CalculationResultsPrinter;

import java.math.BigDecimal;
import java.util.Optional;

public class LoopCalculationExecutor implements CalculationExecutor {

    private OperationConstructor operationConstructor;
    private UserInteractor userInteractor;
    private UserTextPrinter userTextPrinter;
    private CalculationResultsPrinter calculationResultsPrinter;

    public LoopCalculationExecutor(OperationConstructor operationConstructor, UserInteractor userInteractor,
                                   UserTextPrinter userTextPrinter, CalculationResultsPrinter calculationResultsPrinter) {
        this.operationConstructor = operationConstructor;
        this.userInteractor = userInteractor;
        this.userTextPrinter = userTextPrinter;
        this.calculationResultsPrinter = calculationResultsPrinter;
    }

    @Override
    public void execute() {
        boolean continueExecution = true;
        while (continueExecution) {
            try {
                executeSingleOperation();
                continueExecution = userWantsToContinue();
            } catch (Exception e) {
                // remaining test
                System.out.println("Unexpected failure: " + e.getMessage());
                continueExecution = false;
            }
        }
    }

    private void executeSingleOperation() throws Exception {
        try {
            CalculationStatement statement = operationConstructor.fetchCalculationDetails();
            BigDecimal result = statement.getOperation().calculate(
                    statement.getFirstOperand(),
                    statement.getSecondOperand()
            );
            statement.setResult(Optional.of(result));
            calculationResultsPrinter.presentResults(statement);
        } catch (InvalidInformationEnteredException e) {
            userTextPrinter.write(e.getMessage());
        }
    }

    private boolean userWantsToContinue() throws Exception {
        String userResponse = userInteractor
                .writeAndGetResponse("Continue? Type TRUE for yes, FALSE - otherwise.");
        return Boolean.valueOf(userResponse);
    }
}

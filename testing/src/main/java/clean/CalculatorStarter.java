package clean;

import clean.execution.CalculationExecutor;
import clean.execution.LoopCalculationExecutor;
import clean.inputhandling.ConsoleInputReader;
import clean.inputhandling.InputReader;
import clean.operationconstrution.OperationConstructor;
import clean.userinteraction.SystemOutUserInteractor;
import clean.userinteraction.UserInteractor;
import clean.userinteraction.UserTextPrinter;
import clean.userinteraction.resulthandling.CalculationResultsPrinter;

public class CalculatorStarter {

    public static void main (String[] args) {

        InputReader inputReader = new ConsoleInputReader();
        UserInteractor userInteractor = new SystemOutUserInteractor(inputReader);
        OperationConstructor operationConstructor = new OperationConstructor(userInteractor);
        UserTextPrinter userTextPrinter = new SystemOutUserInteractor(inputReader);
        CalculationResultsPrinter calculationResultsPrinter = new CalculationResultsPrinter(userTextPrinter);

        CalculationExecutor executor = new LoopCalculationExecutor(
                operationConstructor, userInteractor, userTextPrinter, calculationResultsPrinter);

        executor.execute();
    }
}

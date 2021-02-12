package clean.operationconstrution;

import clean.entities.CalculationOperations;
import clean.entities.CalculationStatement;
import clean.exceptions.InvalidInformationEnteredException;
import clean.userinteraction.UserInteractor;

import java.math.BigDecimal;

public class OperationConstructor {

    private UserInteractor userInteractor;

    public OperationConstructor(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public CalculationStatement fetchCalculationDetails() throws InvalidInformationEnteredException {
        CalculationOperations operation;
        BigDecimal firstOperand;
        BigDecimal secondOperand;

        try {
            String enteredOperation  = userInteractor.writeAndGetResponse("Enter operation");
            operation = CalculationOperations.valueOf(enteredOperation);
        } catch (Exception e) {
            throw new InvalidInformationEnteredException("Wrong operation");
        }
        try {
            String enteredFirstOperand = userInteractor.writeAndGetResponse("Enter first operand");
            firstOperand = new BigDecimal(enteredFirstOperand);
        } catch (Exception e) {
            throw new InvalidInformationEnteredException("Wrong first operand");
        }
        try {
            String enteredSecondOperand = userInteractor.writeAndGetResponse("Enter second operand");
            secondOperand = new BigDecimal(enteredSecondOperand);
        } catch (Exception e) {
            throw new InvalidInformationEnteredException("Wrong second operand");
        }

        return new CalculationStatement(firstOperand, secondOperand, operation);
    }
}

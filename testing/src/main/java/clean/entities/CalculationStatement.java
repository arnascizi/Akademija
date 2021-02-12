package clean.entities;

import java.math.BigDecimal;
import java.util.Optional;

public class CalculationStatement {

    private BigDecimal firstOperand;
    private BigDecimal secondOperand;
    private CalculationOperations operation;
    private Optional<BigDecimal> result;

    public CalculationStatement() {
        result = Optional.empty();
    }

    public CalculationStatement(BigDecimal firstOperand, BigDecimal secondOperand, CalculationOperations operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
        this.result = Optional.empty();
    }

    public BigDecimal getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(BigDecimal firstOperand) {
        this.firstOperand = firstOperand;
    }

    public BigDecimal getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(BigDecimal secondOperand) {
        this.secondOperand = secondOperand;
    }

    public CalculationOperations getOperation() {
        return operation;
    }

    public void setOperation(CalculationOperations operation) {
        this.operation = operation;
    }

    public Optional<BigDecimal> getResult() {
        return result;
    }

    public void setResult(Optional<BigDecimal> result) {
        this.result = result;
    }
}

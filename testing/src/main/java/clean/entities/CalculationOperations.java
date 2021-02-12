package clean.entities;

import java.math.BigDecimal;

public enum CalculationOperations implements Calculator {

    ADDITION("+") {
        public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
            return firstOperand.add(secondOperand);
        }
    },
    SUBTRACTION("-") {
        public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
            return firstOperand.subtract(secondOperand);
        }
    },
    MULTIPLICATION("*") {
        public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
            return firstOperand.multiply(secondOperand);
        }
    },
    DIVISION("/") {
        public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
            return firstOperand.divide(secondOperand);
        }
    };

    private String operationSymbol;

    CalculationOperations(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }
}

package clean.entities;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand);
}

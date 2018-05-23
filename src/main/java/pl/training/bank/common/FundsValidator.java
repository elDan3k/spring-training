package pl.training.bank.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FundsValidator implements ConstraintValidator<Funds, Long> {

    private long maxValue;

    @Override
    public void initialize(Funds funds) {
        maxValue = funds.maxValue();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        return value > 0 && value <= maxValue;
    }

}

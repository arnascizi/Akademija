package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class MandatoryValueValidator extends Validator<String> {

    @Override
    public void validate(String attribute, String message) {
        if (attribute.trim().isEmpty()) {
            throw new ValidationException(message);
        }
    }
}

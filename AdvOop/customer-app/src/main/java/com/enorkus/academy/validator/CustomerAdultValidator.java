package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CustomerAdultValidator extends Validator<Integer> {

    @Override
    public void validate(Integer attribute, String message) {
        if (attribute < 18) {
            throw new ValidationException(message);
        }
    }
}

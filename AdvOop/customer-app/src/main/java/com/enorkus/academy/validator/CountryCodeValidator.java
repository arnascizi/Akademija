package com.enorkus.academy.validator;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.EnumUtils;


@Component
public class CountryCodeValidator extends Validator<String> {

    @Override
    public void validate(String attribute, String message) {
        if (!EnumUtils.isValidEnum(CountryCode.class, attribute)) {
            throw new ValidationException(message);
        }
    }
}

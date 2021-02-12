package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    @Autowired
    private MandatoryValueValidator mandatoryValidator;

    @Autowired
    private CustomerAdultValidator ageValidator;

    @Autowired
    private CountryCodeValidator countryCodeValidator;

    public void customerValidator(Customer customer) {
        mandatoryValidator.validate(customer.getFirstName(),
                "First name is mandatory!");
        mandatoryValidator.validate(customer.getLastName(),
                "Last name is mandatory!");
        mandatoryValidator.validate(customer.getPersonalNumber(),
                "Personal number is mandatory!");

        ageValidator.validate(customer.getAge(),
                "Age is mandatory. Customer has to be of age 18 and older!");

        countryCodeValidator.validate(customer.getCountryCode(),
                "Invalid country code!");
    }
}

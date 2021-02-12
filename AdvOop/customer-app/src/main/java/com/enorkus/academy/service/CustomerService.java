package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private MemoryCustomerRepository customerRepository;

    @Autowired
    private CustomerValidator customerValidator;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void insertNewCustomer(Customer customer) {
        customerValidator.customerValidator(customer);
        Customer newCustomer = new Customer.CustomerBuilder(
                StringUtils.capitalize(customer.getFirstName()),
                StringUtils.capitalize(customer.getLastName()),
                formatNumber(customer.getPersonalNumber())
        )
                .withMiddleName(customer.getMiddleName())
                .withAge(customer.getAge())
                .withCountryCode(customer.getCountryCode())
                .fromCity(customer.getCity())
                .hasMonthlyIncome(customer.getMonthlyIncome())
                .hasEmployer(customer.getEmployer())
                .whoseGender(customer.getGender())
                .whoseMaritalStatus(customer.getMaritalStatus())
                .build();
        customerRepository.insert(newCustomer);
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private String formatNumber(String number) {
        char dash = '-';
        if (number.length() > 4) {
            if (number.charAt(4) != dash)
                number = number.substring(0, 4) + dash + number.substring(4);
        }
        return number;
    }
}

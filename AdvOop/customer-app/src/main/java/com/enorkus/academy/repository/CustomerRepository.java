package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    void insert(Customer customer);

    void deleteById(String customerId);
}

package com.codegym.customermanagermentthymeleaf.service;

import com.codegym.customermanagermentthymeleaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers();
    void saveCustomer(Customer customer);
    Customer findCustomerById(int id);
    void updateCustomer(int customerId, Customer customer);
    void deleteCustomer(int customerId);
}

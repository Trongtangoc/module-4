package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<model.Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
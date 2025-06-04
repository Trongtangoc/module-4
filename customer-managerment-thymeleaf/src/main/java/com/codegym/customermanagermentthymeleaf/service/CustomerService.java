package com.codegym.customermanagermentthymeleaf.service;

import com.codegym.customermanagermentthymeleaf.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
        customers.put(2, new Customer(2, "Bill", "Bill@codegym.vn", "Da Nang"));
        customers.put(3, new Customer(3, "Alex", "Alex@codegym.vn", "Tp Ho Chi Minh"));
        customers.put(4, new Customer(4, "Adam", "Adam@codegym.vn", "Hai Phong"));
        customers.put(5, new Customer(5, "Jame", "Jame@codegym.vn", "Can Tho"));
        customers.put(6, new Customer(6, "Rosh", "Rosh@codegym.vn", "Hue"));
        customers.put(7, new Customer(7, "Sniper", "Sniper@codegym.vn", "Vung Tau"));
        customers.put(8, new Customer(8, "Haris", "Haris@codegym.vn", "Nha Trang"));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {
        customers.put(customerId, customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customers.remove(customerId);
    }
}

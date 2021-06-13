package ru.auto.dunkan.service;

import ru.auto.dunkan.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void save(Customer customer);

    void delete(Customer customer);

    List<Customer> getAll();
}

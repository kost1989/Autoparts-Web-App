package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Customer;
import ru.auto.dunkan.repo.CustomerRepository;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public Customer get(Long id) {
        return customerRepository.getById(id);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}

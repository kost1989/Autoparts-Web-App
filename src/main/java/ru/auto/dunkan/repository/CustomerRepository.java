package ru.auto.dunkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

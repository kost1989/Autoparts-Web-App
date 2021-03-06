package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

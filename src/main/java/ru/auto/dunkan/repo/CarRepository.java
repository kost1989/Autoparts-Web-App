package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Car;
import ru.auto.dunkan.model.Customer;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

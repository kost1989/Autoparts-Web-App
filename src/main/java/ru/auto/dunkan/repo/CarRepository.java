package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

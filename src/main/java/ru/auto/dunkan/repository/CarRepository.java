package ru.auto.dunkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

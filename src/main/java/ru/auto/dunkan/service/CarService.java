package ru.auto.dunkan.service;

import ru.auto.dunkan.entity.Car;

import java.util.List;

public interface CarService {

    Car getById(Long id);

    void save(Car car);

    void delete(Car car);

    List<Car> getAll();
}

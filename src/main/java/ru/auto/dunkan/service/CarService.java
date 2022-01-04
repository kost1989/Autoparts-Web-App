package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Car;
import ru.auto.dunkan.model.Customer;
import ru.auto.dunkan.repo.CarRepository;

import java.util.List;

@Service
@Transactional
public class CarService {

    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public List<Car> listByCustomer(Customer customer) {
        return carRepository.findAllByCustomerId(customer);
    }

    public Car get(Long id) {
        return carRepository.getById(id);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }
}

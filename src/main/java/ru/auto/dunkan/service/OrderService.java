package ru.auto.dunkan.service;

import ru.auto.dunkan.entity.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long id);

    void save(Order order);

    void delete(Order order);

    List<Order> getAll();
}

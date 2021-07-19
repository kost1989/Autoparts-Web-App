package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Car;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.repo.OrderRepository;

import java.util.List;

@Service
@Transactional
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    public Order get(Long id) {
        return orderRepository.getById(id);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}

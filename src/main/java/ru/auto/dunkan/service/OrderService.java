package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.repo.OrderRepository;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final StatusService statusService;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusService statusService) {
        this.orderRepository = orderRepository;
        this.statusService = statusService;
    }
}

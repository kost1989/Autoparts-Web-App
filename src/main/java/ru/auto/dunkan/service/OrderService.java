package ru.auto.dunkan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auto.dunkan.model.Car;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.repo.OrderRepository;
import ru.auto.dunkan.repo.StatusRepository;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class OrderService {

    OrderRepository orderRepository;
    StatusService statusService;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusService statusService) {
        this.orderRepository = orderRepository;
        this.statusService = statusService;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> listAll() {
        List<Order> orderList = orderRepository.findAll();
        orderList.sort(Comparator.comparingLong(Order::getId));
        return orderList;
    }

    public List<Order> listNotIssuedOrder() {
        List<Order> orderList = orderRepository.findAllByStatusIdBefore(statusService.get(5L));
        orderList.sort(Comparator.comparingLong(Order::getId));
        return orderList;
    }

    public List<Order> listAllSortByStatus(Boolean direction) {
        List<Order> orderList = orderRepository.findAll();
        if (direction) {
            orderList.sort(Comparator.comparingLong(o -> o.getStatusId().getId()));
        } else {
            orderList.sort((o1, o2) -> Long.compare(o2.getStatusId().getId(), o1.getStatusId().getId()));
        }

        return orderList;
    }

    public Order get(Long id) {
        return orderRepository.getById(id);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

}

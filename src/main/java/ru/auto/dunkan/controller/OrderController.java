package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.model.Customer;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public ModelAndView getAllOrders() {
        List<Order> orderList = orderService.listAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }
}

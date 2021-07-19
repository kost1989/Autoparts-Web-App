package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView getOrderById(@RequestParam("id") String id) {
        Order order = orderService.get(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("orderbyid");
        modelAndView.addObject("orderbyid", order);
        return modelAndView;
    }
}

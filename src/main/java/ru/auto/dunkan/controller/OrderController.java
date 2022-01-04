package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.service.CarService;
import ru.auto.dunkan.service.CustomerService;
import ru.auto.dunkan.service.OrderService;
import ru.auto.dunkan.service.StatusService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    OrderService orderService;
    StatusService statusService;
    CustomerService customerService;
    CarService carService;

    String orderSortBy = " ";
    String orderSortDir = " ";

    @Autowired
    public OrderController(OrderService orderService, StatusService statusService, CustomerService customerService, CarService carService) {
        this.orderService = orderService;
        this.statusService = statusService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getAllOrders(@RequestParam(value = "sortBy", required = false, defaultValue = " ") String orderSortBy, @RequestParam(value = "sortDir", required = false, defaultValue = " ") String orderSortDir) {
        ModelAndView modelAndView = new ModelAndView("orders");
        this.orderSortDir = orderSortDir;
        this.orderSortBy = orderSortBy;

        boolean boolDirection = true;

        if (orderSortDir.equals("up")) {
            boolDirection = false;
        }

        List<Order> orderList = null;

        switch (orderSortBy) {
            case "status" :
                orderList = orderService.listAllSortByStatus(boolDirection);
                break;
            default:
                orderList = orderService.listAll();
                break;
        }

        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("orderSortBy", orderSortBy);
        modelAndView.addObject("orderSortDir", orderSortDir);
        return modelAndView;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView getOrderById(@RequestParam("id") String id) {
        Order order = orderService.get(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("orderById");
        modelAndView.addObject("orderbyid", order);
        return modelAndView;
    }

    @RequestMapping(value = "/orderAdd", method = RequestMethod.GET)
    public ModelAndView addOrder() {
        ModelAndView modelAndView = new ModelAndView("orderAdd");
        Order newOrder = new Order(orderService.listAll().size(), statusService.get(1L), LocalDateTime.now());
        modelAndView.addObject("order", newOrder);
        modelAndView.addObject("customers", customerService.listAll());
        modelAndView.addObject("cars", carService);
        return modelAndView;
    }

    @RequestMapping(value = "/orderAdd", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }
}

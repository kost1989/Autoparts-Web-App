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

    String orderSortBy = " ";
    String orderSortDir = " ";

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
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
        ModelAndView modelAndView = new ModelAndView("orderbyid");
        modelAndView.addObject("orderbyid", order);
        return modelAndView;
    }

    // Other

    public void switchOrderSortDir() {

    }
}

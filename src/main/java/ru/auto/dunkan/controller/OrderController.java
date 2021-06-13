package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.entity.Order;
import ru.auto.dunkan.service.OrderService;
import ru.auto.dunkan.service.OrderServiceImpl;

import java.util.List;

@Controller
@Import(OrderServiceImpl.class)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String index(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "orders123";
    }

    @GetMapping(value = "/index.htm")
    public ModelAndView indexPage() {
        return new ModelAndView("index.html");
    }
}

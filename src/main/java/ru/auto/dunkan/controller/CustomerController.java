package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.model.Customer;
import ru.auto.dunkan.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ModelAndView getAllCustomers() {
        List<Customer> customerList = customerService.listAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("statusList", customerList);
        return modelAndView;
    }
}

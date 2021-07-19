package ru.auto.dunkan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartupController {

    @RequestMapping("/")
    public ModelAndView getAllOrders() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}

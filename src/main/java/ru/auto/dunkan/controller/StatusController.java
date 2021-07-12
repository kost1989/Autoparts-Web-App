package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.service.StatusService;

import java.util.List;

@Controller
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/")
    public ModelAndView home() {
        List<Status> statusList = statusService.listAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("statusList", statusList);
        return modelAndView;
    }
}

package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.service.StatusService;

@Controller
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/status/all")
    public String list(Model model) {
        Status status = statusService.getById(0L);
        model.addAttribute(status);
        return "/status/list";
    }
}

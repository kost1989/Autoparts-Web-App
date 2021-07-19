package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.service.StatusService;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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

    @RequestMapping("/status")
    public ModelAndView home() {
        List<Status> statusList = statusService.listAll();
        Collections.sort(statusList, new Comparator<Status>() {
            @Override
            public int compare(Status o1, Status o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }
                if (o1.getId() < o2.getId()) {
                    return -1;
                }
                return 0;
            }
        });
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("statusList", statusList);
        return modelAndView;
    }

/*    @RequestMapping("/initStatus")
    public ModelAndView initStatus() {
        Status status1 = new Status(1, "Не обработан", Color.RED);
        Status status2 = new Status(2, "Заказан", Color.YELLOW);
        Status status3 = new Status(3, "На складе", Color.CYAN);
        Status status4 = new Status(4, "Сообщено", Color.GREEN);
        Status status5 = new Status(5, "Выдан", Color.GRAY);
        Status status6 = new Status(6, "Отменен", Color.DARK_GRAY);

        statusService.save(status1);
        statusService.save(status2);
        statusService.save(status3);
        statusService.save(status4);
        statusService.save(status5);
        statusService.save(status6);

        List<Status> statusList = statusService.listAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("statusList", statusList);
        return modelAndView;
    }*/
}

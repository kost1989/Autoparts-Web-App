package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.service.StatusService;

import java.util.List;

@RequestMapping("${web.prefix}/status")
@RestController
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable(value = "id") Long statusId) {
        return statusService.getById(statusId);
    }

    @GetMapping
    public List<Status> getFilteredList(@RequestParam(value = "id", required = false) Long id,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "color", required = false) String color,
                                        @RequestParam(value = "enabled", required = false, defaultValue = "true")
                                                    Boolean enabled) {
        Status status = new Status();
        if (id != null) {
            status.setId(id);
        }
        if (name != null) {
            status.setName(name);
        }
        if (color != null) {
            status.setColor(color);
        }
        status.setEnabled(enabled);
        return statusService.getListByFilter(status);
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusService.create(status);
    }

    @PutMapping
    public Status updateStatus(@RequestBody Status status) {
        return statusService.update(status);
    }

    @DeleteMapping
    public Status deleteStatus(@RequestBody Status status) {
        return statusService.delete(status);
    }
}

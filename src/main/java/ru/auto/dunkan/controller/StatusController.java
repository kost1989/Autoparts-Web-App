package ru.auto.dunkan.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.service.StatusService;

import javax.validation.constraints.Min;
import java.util.List;

@Tag(name="Контроллер статусов", description="")
@RequestMapping("${web.prefix}/status")
@RestController
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable(value = "id") @Min(0) @Parameter(description = "Идентификатор статуса")Long statusId) {
        return statusService.getById(statusId);
    }

    @GetMapping
    public List<Status> getFilteredList(@RequestParam(value = "id", required = false) @Min(0)
                                            @Parameter(description = "Идентификатор статуса") Long id,
                                        @RequestParam(value = "name", required = false)
                                            @Parameter(description = "Наименование статуса") String name,
                                        @RequestParam(value = "color", required = false)
                                            @Parameter(description = "Цвет статуса") String color,
                                        @RequestParam(value = "enabled", required = false, defaultValue = "true")
                                            @Parameter(description = "Включен ли статус") Boolean enabled) {
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

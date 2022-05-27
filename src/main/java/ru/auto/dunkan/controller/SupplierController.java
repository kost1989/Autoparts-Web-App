package ru.auto.dunkan.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Supplier;
import ru.auto.dunkan.service.SupplierService;

import javax.validation.constraints.Min;
import java.util.List;

@Tag(name="Контроллер поставщиков", description="")
@RequestMapping("${web.prefix}/supplier")
@RestController
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Operation(summary = "Получение поставщика по его идентификатору")
    @GetMapping("/{id}")
    public Supplier getById(@PathVariable("id") @Min(0) @Parameter(description = "Идентификатор поставщика") Long supplierId) {
        return supplierService.getById(supplierId);
    }

    @Operation(summary = "Получение списка поставщиков по заданным параметрам")
    @GetMapping
    public List<Supplier> getFilteredList(@RequestParam(value = "id", required = false) @Min(0)
                                              @Parameter(description = "Идентификатор поставщика") Long id,
                                          @RequestParam(value = "name", required = false)
                                              @Parameter(description = "Наименование поставщика") String name,
                                          @RequestParam(value = "url", required = false)
                                              @Parameter(description = "Сайт поставщика") String url,
                                          @RequestParam(value = "comments", required = false)
                                              @Parameter(description = "Комментарии") String comments,
                                          @RequestParam(value = "enabled", required = false, defaultValue = "true")
                                              @Parameter(description = "Включен ли поставщик")
                                              Boolean enabled) {
        Supplier supplier = new Supplier(id, name, url, comments, enabled);
        return supplierService.getListByFilter(supplier);
    }
}

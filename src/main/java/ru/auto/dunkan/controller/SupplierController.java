package ru.auto.dunkan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Supplier;
import ru.auto.dunkan.service.SupplierService;

import java.util.List;

@RequestMapping("${web.prefix}/supplier")
@RestController
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable("id") Long supplierId) {
        return supplierService.getById(supplierId);
    }

    @GetMapping
    public List<Supplier> getFilteredList(@RequestParam(value = "id", required = false) Long id,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "url", required = false) String url,
                                          @RequestParam(value = "comments", required = false) String comments,
                                          @RequestParam(value = "enabled", required = false, defaultValue = "true")
                                                      Boolean enabled) {
        Supplier supplier = new Supplier();
        if (id != null) {
            supplier.setId(id);
        }
        if (name != null) {
            supplier.setName(name);
        }
        if (url != null) {
            supplier.setUrl(url);
        }
        if (comments != null) {
            supplier.setComments(comments);
        }
        return supplierService.getListByFilter(supplier);
    }
}

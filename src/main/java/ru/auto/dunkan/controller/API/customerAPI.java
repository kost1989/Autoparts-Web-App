package ru.auto.dunkan.controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Customer;
import ru.auto.dunkan.service.CustomerService;

@RestController
public class customerAPI {
    CustomerService customerService;

    @Autowired
    public customerAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/api/customer/add", method = RequestMethod.POST)
    @ResponseBody
    public void addJSONCustomerToDB(@RequestParam("customerName") String customerName,
                                    @RequestParam("customerExtra") String customerExtra,
                                    @RequestParam("customerPhone") String customerPhone) {
        customerService.save(new Customer(customerName, Integer.parseInt(customerExtra), customerPhone));
    }
}

package ru.auto.dunkan.controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Car;
import ru.auto.dunkan.service.CarService;
import ru.auto.dunkan.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class carAPI {
    CarService carService;
    CustomerService customerService;

    @Autowired
    public carAPI(CustomerService customerService, CarService carService) {
        this.customerService = customerService;
        this.carService = carService;
    }

    @RequestMapping(value = "/api/car/id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getJSONCarById(@RequestParam("id") String id) {
        Car car = carService.get(Long.parseLong(id));
        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("id", car.getId() + "");
        jsonMap.put("name", car.getName());
        jsonMap.put("customer", car.getCustomerId().getName());
        return jsonMap;
    }

    @RequestMapping(value = "/api/car/customerId", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, HashMap<String, String>> getArrayOfJSONCarsByCustomer(@RequestParam("customerId") String id) {
        List<Car> cars = carService.listByCustomer(customerService.get(Long.parseLong(id)));
        HashMap<String, HashMap<String, String>> arrayOfJSONMap = new HashMap<>();
        int count = 0;

        for (Car car : cars) {
            HashMap<String, String> jsonMap = new HashMap<>();
            jsonMap.put("id", car.getId() + "");
            jsonMap.put("name", car.getName());
            arrayOfJSONMap.put(count + "", jsonMap);
            count++;
        }

        return arrayOfJSONMap;
    }
}

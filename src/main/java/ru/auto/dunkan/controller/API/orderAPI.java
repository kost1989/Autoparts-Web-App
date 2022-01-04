package ru.auto.dunkan.controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.service.CarService;
import ru.auto.dunkan.service.CustomerService;
import ru.auto.dunkan.service.OrderService;
import ru.auto.dunkan.service.StatusService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class orderAPI {
    OrderService orderService;
    CustomerService customerService;
    CarService carService;
    StatusService statusService;

    @Autowired
    public orderAPI(OrderService orderService, CustomerService customerService,
                    CarService carService, StatusService statusService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.carService = carService;
        this.statusService = statusService;
    }



    @RequestMapping(value = "/api/order/id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getJSONOrderById(@RequestParam("id") String id) {
        Order order = orderService.get(Long.parseLong(id));
        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("id", order.getId() + "");
        jsonMap.put("name", order.getName());
        jsonMap.put("customer", order.getCustomerId().getName());
        return jsonMap;
    }

    @RequestMapping(value = "/api/order/all_not_issued", method = RequestMethod.POST)
    public Map<String, HashMap<String, String>> getJSONOrderAllNotIssued() {
        HashMap<String, HashMap<String, String>> outputJSON = new HashMap<>();
        List<Order> orderList = orderService.listNotIssuedOrder();

        long count = 0;

        for (Order order : orderList) {
            HashMap<String, String> tempInnerJSON = new HashMap<>();
            tempInnerJSON.put("id", order.getId() + "");
            tempInnerJSON.put("name", order.getName());
            tempInnerJSON.put("customer", order.getCustomerId().getName());
            tempInnerJSON.put("car", order.getCarId().getName());
            outputJSON.put(count + "", tempInnerJSON);
            count++;
        }

        return outputJSON;
    }

    @RequestMapping(value = "/api/order/add", method = RequestMethod.POST)
    @ResponseBody
    public void addJSONOrderToDB(@RequestParam("orderCostCustomer") String orderCostCustomer,
                                 @RequestParam("orderCostOrigin") String orderCostOrigin,
                                 @RequestParam("orderName") String orderName,
                                 @RequestParam("orderCarId") String orderCarId,
                                 @RequestParam("orderCustomerId") String orderCustomerId,
                                 @RequestParam("orderComments") String orderComments) {


        orderService.save(new Order(orderName,
                customerService.get(Long.parseLong(orderCustomerId)),
                carService.get(Long.parseLong(orderCarId)),
                Long.parseLong(orderCostOrigin),
                Long.parseLong(orderCostCustomer),
                orderComments,
                statusService.get(1L),
                LocalDateTime.now()));
    }
}

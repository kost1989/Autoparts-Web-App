package ru.auto.dunkan.controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Order;
import ru.auto.dunkan.service.CarService;
import ru.auto.dunkan.service.CustomerService;
import ru.auto.dunkan.service.OrderService;
import ru.auto.dunkan.service.StatusService;

import java.time.LocalDateTime;
import java.util.ArrayList;
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



    @RequestMapping(value = "/api/order/get/by_id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getJSONOrderById(@RequestParam("id") String id) {
        Order order = orderService.get(Long.parseLong(id));
        return getHashMapJSONOfOrder(order);
    }

    @RequestMapping(value = "/api/order/get/all_not_issued", method = RequestMethod.POST)
    public List<HashMap<String, String>> getJSONOrderAllNotIssued() {
        List<HashMap<String, String>> outputJSON = new ArrayList<>();
        List<Order> orderList = orderService.listNotIssuedOrder();

        return getOrderListJSON(outputJSON, orderList);
    }

    @RequestMapping(value = "/api/order/get/all", method = RequestMethod.POST)
    public List<HashMap<String, String>> getJSONOrderAll() {
        List<HashMap<String, String>> outputJSON = new ArrayList<>();
        List<Order> orderList = orderService.listAll();

        return getOrderListJSON(outputJSON, orderList);
    }

    private List<HashMap<String, String>> getOrderListJSON(List<HashMap<String, String>> outputJSON, List<Order> orderList) {
        for (Order order : orderList) {
            HashMap<String, String> tempInnerJSON = getHashMapJSONOfOrder(order);
            outputJSON.add(tempInnerJSON);
        }

        return outputJSON;
    }

    private HashMap<String, String> getHashMapJSONOfOrder(Order order) {
        HashMap<String, String> tempInnerJSON = new HashMap<>();
        tempInnerJSON.put("id", order.getId() + "");
        tempInnerJSON.put("name", order.getName());
        tempInnerJSON.put("customer", order.getCustomerId().getName());
        tempInnerJSON.put("car", order.getCarId().getName());
        tempInnerJSON.put("status", order.getStatusId().getName());
        tempInnerJSON.put("status_color", order.getStatusId().getColor());
        tempInnerJSON.put("cost_origin", String.valueOf(order.getCostOrigin()));
        tempInnerJSON.put("cost_customer", String.valueOf(order.getCostCustomer()));
        tempInnerJSON.put("date_start", String.valueOf(order.getDateStart()));
        tempInnerJSON.put("date_end", String.valueOf(order.getDateEnd()));
        tempInnerJSON.put("date_given_away", String.valueOf(order.getDateGivenAway()));
        tempInnerJSON.put("comments", order.getOrderComments());
        return tempInnerJSON;
    }


    @RequestMapping(value = "/api/order/put", method = RequestMethod.POST)
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

    @RequestMapping(value = "/api/order/save/all", method = RequestMethod.POST)
    @ResponseBody
    public void saveJSONOrderToDB(@RequestParam("orderId") String orderId,
                                  @RequestParam("orderName") String orderName,
                                  @RequestParam("orderCustomerId") String orderCustomerId,
                                  @RequestParam("orderCarId") String orderCarId,
                                  @RequestParam("orderCostOrigin") String orderCostOrigin,
                                  @RequestParam("orderCostCustomer") String orderCostCustomer,
                                  @RequestParam("orderStatusId") String orderStatusId,
                                  @RequestParam("orderDateStart") String orderDateStart,
                                  @RequestParam("orderDateEnd") String orderDateEnd,
                                  @RequestParam("orderDateGivenAway") String orderDateGivenAway,
                                  @RequestParam("orderComments") String orderComments) {

        Order order = orderService.get(Long.parseLong(orderId));

        order.setAllAvailableAttributes(orderName,
                                        customerService.get(Long.parseLong(orderCustomerId)),
                                        carService.get(Long.parseLong(orderCarId)),
                                        Long.parseLong(orderCostOrigin),
                                        Long.parseLong(orderCostCustomer),
                                        statusService.get(Long.parseLong(orderStatusId)),
                                        LocalDateTime.parse(orderDateStart),
                                        LocalDateTime.parse(orderDateEnd),
                                        LocalDateTime.parse(orderDateGivenAway),
                                        orderComments);

        orderService.save(order);
    }
}

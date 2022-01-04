package ru.auto.dunkan.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    //Standard from spring.io

    protected Order() {

    }

    public Order(long id, String name, Customer customerId, Car carId, long costOrigin, long costCustomer,
                 Status statusId, LocalDateTime dateStart, String comments) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.carId = carId;
        this.costOrigin = costOrigin;
        this.costCustomer = costCustomer;
        this.statusId = statusId;
        this.dateStart = dateStart;
        this.orderComments = comments;
    }

    public Order(String name, Customer customerId, Car carId, long costOrigin, long costCustomer,
                 String comments, Status statusId, LocalDateTime dateStart) {
        this.name = name;
        this.customerId = customerId;
        this.carId = carId;
        this.costOrigin = costOrigin;
        this.costCustomer = costCustomer;
        this.orderComments = comments;
        this.statusId = statusId;
        this.dateStart = dateStart;
    }

    public Order(long id, Status statusId, LocalDateTime dateStart) {
        this.id = id;
        this.dateStart = dateStart;
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", costOrigin=" + costOrigin +
                ", costCustomer=" + costCustomer +
                ", statusId=" + statusId +
                ", date_start=" + dateStart +
                ", date_end=" + dateEnd +
                ", date_given_away=" + dateGivenAway +
                '}';
    }

    //Table description

    @Id
    @Column(name = "order_id")
    @SequenceGenerator(name = "jpaSequenceOrder", sequenceName = "JPA_SEQUENCE_ORDER", allocationSize = 1, initialValue = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceOrder")
    private long id;

    // Наименование заказа
    @Column(name = "order_name")
    private String name;

    // Заказчик
    @ManyToOne
    @JoinColumn(name = "order_customer_id")
    private Customer customerId;

    // Машина для которой заказывается деталь
    @ManyToOne
    @JoinColumn(name = "order_car_id")
    private Car carId;

    // Изначальная стоимость
    @Column(name = "order_cost_origin")
    private long costOrigin;

    // Стоимость для заказчика
    @Column(name = "order_cost_customer")
    private long costCustomer;

    // Статус заказа
    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private Status statusId;

    // Дата заказа
    @Column(name = "order_date_start")
    private LocalDateTime dateStart;

    // Дата прибытия заказа на склад
    @Column(name = "order_date_end")
    private LocalDateTime dateEnd;

    // Дата выдачи заказа заказчику
    @Column(name = "order_date_given_away")
    private LocalDateTime dateGivenAway;

    // Комментарии к заказу
    @Column(name = "order_comments")
    private String orderComments;

    // Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public Car getCarId() {
        return carId;
    }

    public long getCostOrigin() {
        return costOrigin;
    }

    public long getCostCustomer() {
        return costCustomer;
    }

    public Status getStatusId() {
        return statusId;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public LocalDateTime getDateGivenAway() {
        return dateGivenAway;
    }

    public String getOrderComments() {
        return orderComments;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public void setCostOrigin(long costOrigin) {
        this.costOrigin = costOrigin;
    }

    public void setCostCustomer(long costCustomer) {
        this.costCustomer = costCustomer;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDateGivenAway(LocalDateTime dateGivenAway) {
        this.dateGivenAway = dateGivenAway;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    public void setAllAvailableAttributes(String name,
                                          Customer customerId,
                                          Car carId,
                                          Long costOrigin,
                                          Long costCustomer,
                                          Status statusId,
                                          LocalDateTime dateStart,
                                          LocalDateTime dateEnd,
                                          LocalDateTime dateGivenAway,
                                          String orderComments) {
        this.name = name;
        this.customerId = customerId;
        this.carId = carId;
        this.costOrigin = costOrigin;
        this.costCustomer = costCustomer;
        this.statusId = statusId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dateGivenAway = dateGivenAway;
        this.orderComments = orderComments;
    }
}

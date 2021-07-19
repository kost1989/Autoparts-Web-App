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
                 Status statusId, LocalDateTime date_start) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.carId = carId;
        this.costOrigin = costOrigin;
        this.costCustomer = costCustomer;
        this.statusId = statusId;
        this.date_start = date_start;
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
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                ", date_given_away=" + date_given_away +
                '}';
    }

    //Table description

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "order_customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "order_car_id")
    private Car carId;

    @Column(name = "order_cost_origin")
    private long costOrigin;

    @Column(name = "order_cost_customer")
    private long costCustomer;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private Status statusId;

    @Column(name = "order_date_start")
    private LocalDateTime date_start;

    @Column(name = "order_date_end")
    private LocalDateTime date_end;

    @Column(name = "order_date_given_away")
    private LocalDateTime date_given_away;

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

    public LocalDateTime getDate_start() {
        return date_start;
    }

    public LocalDateTime getDate_end() {
        return date_end;
    }

    public LocalDateTime getDate_given_away() {
        return date_given_away;
    }
}

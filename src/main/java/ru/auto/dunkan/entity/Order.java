package ru.auto.dunkan.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car carId;
    private long costOrigin;
    private long costCustomer;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    @Column(name = "order_date_start")
    private LocalDateTime date_start;

    @Column(name = "order_date_end")
    private LocalDateTime date_end;

    @Column(name = "order_date_given_away")
    private LocalDateTime date_given_away;

}

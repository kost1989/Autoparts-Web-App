package ru.auto.dunkan.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "car_vin")
    private String vin;

    @Column(name = "car_year")
    private int year;

    @Column(name = "car_comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
}

package ru.auto.dunkan.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_extra")
    private int extra;

    @Column(name = "customer_phone")
    private String phone;

    //@OneToMany(mappedBy = "car")
    //private List<Car> carList;
}

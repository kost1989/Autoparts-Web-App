package ru.auto.dunkan.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    //Standard from spring.io

    protected Customer() {
    }

    public Customer(long id, String name, int extra, String phone) {
        this.id = id;
        this.name = name;
        this.extra = extra;
        this.phone = phone;
    }

    public Customer(String name, int extra, String phone) {
        this.name = name;
        this.extra = extra;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extra=" + extra +
                ", phone='" + phone + '\'' +
                ", carList=" + carList +
                '}';
    }

    //Table description

    @Id
    @Column(name = "customer_id")
    @SequenceGenerator(name = "jpaSequenceCustomer", sequenceName = "JPA_SEQUENCE_CUSTOMER", allocationSize = 1, initialValue = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceCustomer")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_extra")
    private int extra;

    @Column(name = "customer_phone")
    private String phone;

    @OneToMany
    private List<Car> carList;

    // Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExtra() {
        return extra;
    }

    public String getPhone() {
        return phone;
    }

    public List<Car> getCarList() {
        return carList;
    }
}

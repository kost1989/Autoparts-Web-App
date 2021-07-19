package ru.auto.dunkan.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    //Standard from spring.io

    protected Car() {
    }

    public Car(long id, String name, String vin, int year, String comments) {
        this.id = id;
        this.name = name;
        this.vin = vin;
        this.year = year;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                ", comments='" + comments + '\'' +
                '}';
    }

    //Table description

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
    private Customer customerId;

    // Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getComments() {
        return comments;
    }

    public Customer getCustomerId() {
        return customerId;
    }
}

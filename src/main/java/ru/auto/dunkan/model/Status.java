package ru.auto.dunkan.model;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
public class Status implements Serializable {

    //Standard from spring.io
    protected Status() {
    }

    public Status(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.enabled = true;
    }

    public Status(String name, String color) {
        this.name = name;
        this.color = color;
        this.enabled = true;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }

    //Table description

    @Id
    @Column(name = "status_id")
    @SequenceGenerator(name = "jpaSequenceStatus", sequenceName = "JPA_SEQUENCE_Status", allocationSize = 1, initialValue = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceStatus")
    private long id;

    @Column(name = "status_name")
    private String name;

    @Column(name = "status_color")
    private String color;

    @Column(name = "status_enabled")
    private Boolean enabled;

    @ManyToOne
    private Order orderId;

    // Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Order getOrderId() {
        return orderId;
    }

    // Setters

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

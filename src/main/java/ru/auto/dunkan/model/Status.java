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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status_name")
    private String name;

    @Column(name = "status_color")
    private String color;

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
}

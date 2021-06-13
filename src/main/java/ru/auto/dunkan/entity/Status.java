package ru.auto.dunkan.entity;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status_name")
    private String name;

    @Column(name = "status_color")
    private Color color;
}

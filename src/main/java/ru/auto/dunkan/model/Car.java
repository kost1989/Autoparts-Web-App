package ru.auto.dunkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceCar", sequenceName = "JPA_SEQUENCE_CAR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceCar")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vin")
    private String vin;

    @Column(name = "year")
    private Integer year;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private Customer customer;
}

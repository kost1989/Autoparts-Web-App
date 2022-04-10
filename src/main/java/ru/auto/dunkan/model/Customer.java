package ru.auto.dunkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceCustomer", sequenceName = "JPA_SEQUENCE_CUSTOMER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceCustomer")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToMany
    private List<Car> carList;
}

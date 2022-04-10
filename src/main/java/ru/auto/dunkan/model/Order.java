package ru.auto.dunkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceOrder", sequenceName = "JPA_SEQUENCE_ORDER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceOrder")
    private Long id;

    // Наименование заказа
    @Column(name = "name")
    private String name;

    // Заказчик
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    // Статус заказа
    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    // Детали
    @OneToMany
    @JoinColumn(name = "parts")
    private List<Part> parts;

    // Дата заказа
    @Column(name = "date_start")
    private LocalDateTime dateStart;

    // Дата выдачи заказа заказчику
    @Column(name = "date_given_away")
    private LocalDateTime dateGivenAway;

    // Комментарии к заказу
    @Column(name = "comments")
    private String comments;
}

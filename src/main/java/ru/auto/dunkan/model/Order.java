package ru.auto.dunkan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Сущность заказа")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Schema(description = "Идентификатор")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceOrder", sequenceName = "JPA_SEQUENCE_ORDER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceOrder")
    private Long id;

    @Schema(description = "Наименование")
    @Column(name = "name")
    private String name;

    @Schema(description = "Заказчик")
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Schema(description = "Статус")
    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    @Schema(description = "Детали")
    @OneToMany
    @JoinColumn(name = "parts")
    private List<Part> parts;

    @Schema(description = "Дата заказа")
    @JsonProperty("date_start")
    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Schema(description = "Дата выдачи заказа заказчику")
    @JsonProperty("date_given_away")
    @Column(name = "date_given_away")
    private LocalDateTime dateGivenAway;

    @Schema(description = "Комментарии к заказу")
    @Column(name = "comments")
    private String comments;
}

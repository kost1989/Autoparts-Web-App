package ru.auto.dunkan.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Schema(description = "Сущность автомобиля")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Schema(description = "Идентификатор")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceCar", sequenceName = "JPA_SEQUENCE_CAR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceCar")
    private Long id;

    @Schema(description = "Наименование")
    @Column(name = "name")
    private String name;

    @Schema(description = "VIN-код")
    @Column(name = "vin")
    private String vin;

    @Schema(description = "Год выпуска")
    @Column(name = "year")
    private Integer year;

    @Schema(description = "Комментарии")
    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private Customer customer;
}

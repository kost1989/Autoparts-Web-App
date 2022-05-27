package ru.auto.dunkan.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Schema(description = "Сущность заказчика")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Schema(description = "Идентификатор")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceCustomer", sequenceName = "JPA_SEQUENCE_CUSTOMER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceCustomer")
    private Long id;

    @Schema(description = "Наименование")
    @Column(name = "name")
    private String name;

    @Schema(description = "Телефон")
    @Column(name = "phone")
    private String phone;

    @OneToMany
    private List<Car> carList;
}

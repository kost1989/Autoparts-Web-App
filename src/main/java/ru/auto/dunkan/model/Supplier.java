package ru.auto.dunkan.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Schema(description = "Сущность поставщика")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Schema(description = "Идентификатор")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceSupplier", sequenceName = "JPA_SEQUENCE_SUPPLIER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceSupplier")
    private Long id;

    @Schema(description = "Наименование")
    @Column(name = "name")
    private String name;

    @Schema(description = "Сайт")
    @Column(name = "url")
    private String url;

    @Schema(description = "Комментарии")
    @Column(name = "comments")
    private String comments;

    @Schema(description = "Включен")
    @Column(name = "enabled")
    private Boolean enabled;
}

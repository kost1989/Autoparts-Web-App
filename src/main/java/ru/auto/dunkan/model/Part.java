package ru.auto.dunkan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Schema(description = "Сущность детали")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Part {

    @Schema(description = "Идентификатор")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequencePart", sequenceName = "JPA_SEQUENCE_PART", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequencePart")
    private Long id;

    @Schema(description = "Наименование")
    @Column(name = "name")
    private String name;

    @Schema(description = "Артикул")
    @Column(name = "article")
    private String article;

    @Schema(description = "Цена закупочная одной штуки")
    @JsonProperty("purchase_price")
    @Column(name = "purchase_price")
    private Long purchasePrice;

    @Schema(description = "Цена продажи одной штуки")
    @JsonProperty("sale_price")
    @Column(name = "sale_price")
    private Long salePrice;

    @Schema(description = "Количество")
    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    private Supplier supplier;
}

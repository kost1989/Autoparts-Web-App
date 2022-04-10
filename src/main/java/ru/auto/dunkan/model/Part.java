package ru.auto.dunkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Part {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequencePart", sequenceName = "JPA_SEQUENCE_PART", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequencePart")
    private Long id;

    // Наименование
    @Column(name = "name")
    private String name;

    // Артикул
    @Column(name = "article")
    private String article;

    // Цена закупочная одной штуки
    @Column(name = "purchase_price")
    private Long purchasePrice;

    // Цена продажи одной штуки
    @Column(name = "sale_price")
    private Long salePrice;

    // Количество
    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    private Supplier supplier;
}

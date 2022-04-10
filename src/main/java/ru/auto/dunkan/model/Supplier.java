package ru.auto.dunkan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceSupplier", sequenceName = "JPA_SEQUENCE_SUPPLIER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceSupplier")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "comments")
    private String comments;

    @Column(name = "enabled")
    private Boolean enabled;
}

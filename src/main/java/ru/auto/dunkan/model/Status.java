package ru.auto.dunkan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status")
public class Status implements Serializable {
    @JsonProperty("id")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceStatus", sequenceName = "JPA_SEQUENCE_STATUS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceStatus")
    private Long id;

    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "color")
    @Column(name = "color")
    private String color;

    @JsonProperty(value = "enabled")
    @Column(name = "enabled")
    private Boolean enabled;

    @JsonIgnore
    @ManyToOne
    private Order order;
}

package ru.auto.dunkan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Schema(description = "Сущность статуса")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Schema(description = "Идентификатор")
    @JsonProperty("id")
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "jpaSequenceStatus", sequenceName = "JPA_SEQUENCE_STATUS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequenceStatus")
    private Long id;

    @Schema(description = "Наименование")
    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @Schema(description = "Цвет")
    @JsonProperty(value = "color")
    @Column(name = "color")
    private String color;

    @Schema(description = "Включен")
    @JsonProperty(value = "enabled")
    @Column(name = "enabled")
    private Boolean enabled;

    @JsonIgnore
    @ManyToOne
    private Order order;
}

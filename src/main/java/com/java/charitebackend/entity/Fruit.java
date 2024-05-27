package com.java.charitebackend.entity;

import com.java.charitebackend.enums.FruitTypeEnum;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private FruitTypeEnum type;
    private int quantity;
    private String color;

}

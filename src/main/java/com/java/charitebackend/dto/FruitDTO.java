package com.java.charitebackend.dto;

import com.java.charitebackend.enums.FruitTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitDTO {
    private FruitTypeEnum type;
    private int quantity;
    private String color;

}

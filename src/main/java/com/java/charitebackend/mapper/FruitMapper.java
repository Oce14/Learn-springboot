package com.java.charitebackend.mapper;

import com.java.charitebackend.dto.FruitDTO;
import com.java.charitebackend.entity.Fruit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FruitMapper {
    FruitDTO toDTO(Fruit fruit);
    Fruit toEntity(FruitDTO fruitDTO);

    List<FruitDTO> toDTOList(List<Fruit> fruit);


}

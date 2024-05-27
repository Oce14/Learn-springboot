package com.java.charitebackend.service;

import com.java.charitebackend.dto.FruitDTO;
import com.java.charitebackend.entity.Fruit;
import com.java.charitebackend.enums.FruitTypeEnum;
import com.java.charitebackend.mapper.FruitMapper;
import com.java.charitebackend.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitMapper fruitMapper;
    private final FruitRepository fruitRepository;

    public FruitService(FruitMapper fruitMapper, FruitRepository fruitRepository) {
        this.fruitMapper = fruitMapper;
        this.fruitRepository = fruitRepository;

    }

    public List<FruitDTO> getAllFruits() {
        List<Fruit> myFruit = fruitRepository.findAll();
        return fruitMapper.toDTOList(myFruit);
    }

    public FruitDTO getFruitById(Long id) {
        Fruit myFruit= fruitRepository.findById(id).orElse(null);
        return fruitMapper.toDTO(myFruit);
    }

    public void saveFruit(FruitDTO fruit) {
        Fruit existingFruit = fruitRepository.findByTypeAndColor(fruit.getType(), fruit.getColor());
        if (existingFruit != null) {
            existingFruit.setQuantity(existingFruit.getQuantity() + fruit.getQuantity());
            fruitRepository.save(existingFruit);
        }
        else {
            fruitRepository.save(fruitMapper.toEntity(fruit));
        }
    }

    public void changeQuantity(String color, FruitTypeEnum type, int quantity){
        Fruit existingFruit=fruitRepository.findByTypeAndColor(type,color);
        existingFruit.setQuantity(quantity);
        fruitRepository.save(existingFruit);
    }

    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }


}

package com.java.charitebackend.repository;

import com.java.charitebackend.entity.Fruit;
import com.java.charitebackend.enums.FruitTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Fruit findByTypeAndColor(FruitTypeEnum type, String color);
}

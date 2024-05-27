package com.java.charitebackend.controller;


import com.java.charitebackend.dto.FruitDTO;
import com.java.charitebackend.entity.Fruit;
import com.java.charitebackend.enums.FruitTypeEnum;
import com.java.charitebackend.service.FruitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @ApiOperation(value = "Get all fruits")
    @GetMapping
    public ResponseEntity<List<FruitDTO>> getAllFruits() {
        List<FruitDTO> myFruit = fruitService.getAllFruits();
        return new ResponseEntity<>(myFruit, HttpStatus.OK);
    }

    @ApiOperation(value = "Get fruit by id")
    @GetMapping("/{id}")
    public ResponseEntity<FruitDTO> getFruitById(@PathVariable Long id) {
        FruitDTO myFruit= fruitService.getFruitById(id);
        return new ResponseEntity<>(myFruit, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveFruit(@RequestBody FruitDTO fruit) {
        fruitService.saveFruit(fruit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{type}/{color}/{quantity}")
    public ResponseEntity<String> changeQuantity(@PathVariable String color, @PathVariable FruitTypeEnum type, @PathVariable int quantity){
        fruitService.changeQuantity(color,type,quantity);
        return new ResponseEntity<>("Ok", HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
    }
}

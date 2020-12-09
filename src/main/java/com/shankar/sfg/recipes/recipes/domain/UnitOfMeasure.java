package com.shankar.sfg.recipes.recipes.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class UnitOfMeasure {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}

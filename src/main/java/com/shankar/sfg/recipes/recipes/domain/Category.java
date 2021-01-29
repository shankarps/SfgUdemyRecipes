package com.shankar.sfg.recipes.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy="categories")
    //Exclude this in To String to avoid recursive calls
    @ToString.Exclude
    private Set<Recipe> recipes;


}

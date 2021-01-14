package com.shankar.sfg.recipes.recipes.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CategoryTest {

    static Category category;

    @BeforeAll
    public static void setup(){
        category = new Category();
        category.setId(42L);
    }

    @Test
    void getId() {
        assertEquals(category.getId(), 42L);
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}
package com.shankar.sfg.recipes.recipes.services;

import com.shankar.sfg.recipes.recipes.domain.Difficulty;
import com.shankar.sfg.recipes.recipes.domain.Recipe;
import com.shankar.sfg.recipes.recipes.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;

    @BeforeEach
    public void setup(){
        System.out.println("setting up Mock return values");
        Set<Recipe> recipes= new HashSet<>();
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("Directions");

        recipes.add(guacRecipe);
        when(recipeRepository.findAll()).thenReturn(recipes);
    }

    @Test
    void getAllRecipes() {
        Set<Recipe> recipeSet = recipeService.getAllRecipes();
        assert(recipeSet.size() ==1);
        verify(recipeRepository, times(1)).findAll();

    }
}
package com.shankar.sfg.recipes.recipes.controllers;

import com.shankar.sfg.recipes.recipes.domain.Recipe;
import com.shankar.sfg.recipes.recipes.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @InjectMocks
    IndexController indexController;

    @BeforeEach
    public void setup(){
        System.out.println("Setup");
        //given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe1.setId(2L);

        recipes.add(recipe1);
        recipes.add(recipe2);
        when(recipeService.getAllRecipes()).thenReturn(recipes);
    }

    @Test
    void getIndexPage() {

        String st = indexController.getIndexPage(model);
        assertEquals(st, "index");
        //verify that the recipeService.getAllRecipes() method is called once
        verify(recipeService, times(1)).getAllRecipes();

        //Arg captor is needed to capture an arg of a mocked object.
        ArgumentCaptor<Set<Recipe>> recipeArgCaptor = ArgumentCaptor.forClass(Set.class);
        //verify that model.addAttriute() is called, to et attribute "recipes"
        //Also capture the set value in captor.
        verify(model, times(1))
                .addAttribute(eq("recipes"), recipeArgCaptor.capture());
        assertEquals(recipeArgCaptor.getValue().size(), 2);

    }
}
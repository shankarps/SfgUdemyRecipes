package com.shankar.sfg.recipes.recipes.controllers;

import com.shankar.sfg.recipes.recipes.domain.Recipe;
import com.shankar.sfg.recipes.recipes.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(IndexController.class)
public class IndexControllerWebMVCTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @Test
    void tetIndexControllerMVC() throws Exception {
        //given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe1.setId(2L);

        recipes.add(recipe1);
        recipes.add(recipe2);
        when(service.getAllRecipes()).thenReturn(recipes);

        mockMvc.perform(get("/")).andExpect(status().isOk())
        .andExpect(view().name("index"));
    }
}

package com.shankar.sfg.recipes.recipes.services;


import com.shankar.sfg.recipes.recipes.domain.Recipe;
import com.shankar.sfg.recipes.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        HashSet<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes:: add);
        return recipes;
    }
}

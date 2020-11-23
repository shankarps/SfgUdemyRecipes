package com.shankar.sfg.recipes.recipes.services;

import com.shankar.sfg.recipes.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();
}

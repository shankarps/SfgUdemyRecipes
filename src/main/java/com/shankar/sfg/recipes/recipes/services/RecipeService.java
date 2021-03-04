package com.shankar.sfg.recipes.recipes.services;

import com.shankar.sfg.recipes.recipes.domain.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();

    Recipe getRecipeById(long i);
}

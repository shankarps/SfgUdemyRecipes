package com.shankar.sfg.recipes.recipes.services;


import com.shankar.sfg.recipes.recipes.domain.Recipe;
import com.shankar.sfg.recipes.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        log.info("Getting all recipes");
        HashSet<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes:: add);
        log.info("After getting recipes "+recipes.size());
        return recipes;
    }

    @Override
    public Recipe getRecipeById(long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("Recipe not found");
        }
        return optionalRecipe.get();
    }
}

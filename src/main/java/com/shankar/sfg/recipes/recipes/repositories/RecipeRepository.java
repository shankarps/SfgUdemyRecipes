package com.shankar.sfg.recipes.recipes.repositories;

import com.shankar.sfg.recipes.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

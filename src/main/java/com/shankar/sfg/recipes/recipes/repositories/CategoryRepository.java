package com.shankar.sfg.recipes.recipes.repositories;

import com.shankar.sfg.recipes.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}

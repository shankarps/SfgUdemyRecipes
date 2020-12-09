package com.shankar.sfg.recipes.recipes.controllers;

import com.shankar.sfg.recipes.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.info("Getting all recipes");
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}

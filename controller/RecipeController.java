package com.example.meucardapioseguro.controller;

import com.example.meucardapioseguro.model.Recipe;
import com.example.meucardapioseguro.services.RecipeService;
import com.example.meucardapioseguro.exception.RecipeNotFoundException;
import com.example.meucardapioseguro.exception.InvalidRecipeException;

import java.util.List;

public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public boolean addRecipe(Recipe recipe) {
        try {
            return recipeService.addRecipe(recipe);
        } catch (InvalidRecipeException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Recipe getRecipeById(Long id) {
        try {
            return recipeService.getRecipeById(id);
        } catch (RecipeNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    public boolean removeRecipeById(Long id) {
        try {
            return recipeService.removeRecipeById(id);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean updateRecipe(Recipe recipe) {
        try {
            return recipeService.updateRecipe(recipe);
        } catch (RecipeNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}

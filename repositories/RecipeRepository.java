package com.example.meucardapioseguro.repositories;

import com.example.meucardapioseguro.model.Recipe;

import java.util.HashMap;
import java.util.Map;

public class RecipeRepository {

    private final Map<Long, Recipe> recipeMapById;
    private long currentId;

    public RecipeRepository() {
        this.recipeMapById = new HashMap<>();
        this.currentId = 1L;
    }

    public boolean saveRecipe(Recipe recipe) {
        if (recipe == null || recipe.getName() == null || recipe.getInstructions() == null) {
            throw new IllegalArgumentException("Recipe cannot be null and must have a name and instructions.");
        }
        recipe.setId(currentId++);
        recipeMapById.put(recipe.getId(), recipe);
        return true;
    }

    public Recipe findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return recipeMapById.get(id);
    }

    public boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return recipeMapById.remove(id) != null;
    }

    public boolean updateRecipe(Recipe recipe) {
        if (recipe == null || recipe.getId() == null) {
            throw new IllegalArgumentException("Recipe and ID cannot be null.");
        }
        if (!recipeMapById.containsKey(recipe.getId())) {
            return false;
        }
        recipeMapById.put(recipe.getId(), recipe);
        return true;
    }
}

package com.example.meucardapioseguro.services;

import com.example.meucardapioseguro.model.Recipe;
import com.example.meucardapioseguro.exception.RecipeNotFoundException;
import com.example.meucardapioseguro.exception.InvalidRecipeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeService {

    private final Map<Long, Recipe> recipeMapById;
    private long currentId;

    public RecipeService() {
        this.recipeMapById = new HashMap<>();
        this.currentId = 1L;
    }

    // Adiciona uma nova receita
    public synchronized boolean addRecipe(Recipe recipe) throws InvalidRecipeException {
        if (recipe == null || recipe.getName() == null || recipe.getInstructions() == null) {
            throw new InvalidRecipeException("Receita inválida. Verifique se todos os campos obrigatórios estão preenchidos.");
        }
        recipe.setId(currentId++);
        recipeMapById.put(recipe.getId(), recipe);
        return true;
    }

    // Obtém uma receita por ID
    public synchronized Recipe getRecipeById(Long id) throws RecipeNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        Recipe recipe = recipeMapById.get(id);
        if (recipe == null) {
            throw new RecipeNotFoundException("Receita não encontrada com o ID: " + id);
        }
        return recipe;
    }

    // Lista todas as receitas
    public synchronized List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeMapById.values());
    }

    // Remove uma receita por ID
    public synchronized boolean removeRecipeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        Recipe recipe = recipeMapById.remove(id);
        return recipe != null;
    }

    // Atualiza informações de uma receita
    public synchronized boolean updateRecipe(Recipe recipe) throws RecipeNotFoundException {
        if (recipe == null || recipe.getId() == null) {
            throw new IllegalArgumentException("Receita ou ID não pode ser nulo.");
        }
        if (!recipeMapById.containsKey(recipe.getId())) {
            throw new RecipeNotFoundException("Receita não encontrada com o ID: " + recipe.getId());
        }
        recipeMapById.put(recipe.getId(), recipe);
        return true;
    }
}

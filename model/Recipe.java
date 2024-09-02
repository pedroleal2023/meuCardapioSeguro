package com.example.meucardapioseguro.model;

import java.util.List;

public class Recipe {

    private Long id;
    private String name;
    private String description;
    private List<String> ingredients; // Lista de ingredientes, pode ser substituída por uma classe específica de Ingrediente
    private String instructions;
    private Integer preparationTime; // Tempo de preparo em minutos
    private Integer cookingTime; // Tempo de cozimento em minutos
    private Integer totalTime; // Tempo total em minutos
    private String imageUrl; // URL da imagem da receita

    // Construtor padrão
    public Recipe() {
    }

    // Construtor completo
    public Recipe(Long id, String name, String description, List<String> ingredients, String instructions,
                  Integer preparationTime, Integer cookingTime, Integer totalTime, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.totalTime = totalTime;
        this.imageUrl = imageUrl;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                ", preparationTime=" + preparationTime +
                ", cookingTime=" + cookingTime +
                ", totalTime=" + totalTime +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

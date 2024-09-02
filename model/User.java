package com.example.meucardapioseguro.model;

import java.util.List;

public class User {

    private Long id;
    private String name;
    private String email;
    private List<String> alergias;


    public User(Long id, String name, String email, List<String> alergias) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.alergias = alergias;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAllergies(List<String> alergias) {
        this.alergias = alergias;
    }
}

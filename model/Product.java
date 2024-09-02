package com.example.meucardapioseguro.model;

public class Product {

    private Long id;
    private String name;
    private String barcode;
    private String description;

    // Construtores
    public Product() {}

    public Product(Long id, String name, String barcode, String description) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.description = description;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

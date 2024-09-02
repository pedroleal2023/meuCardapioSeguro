package com.example.meucardapioseguro.controller;

import com.example.meucardapioseguro.model.Product;
import com.example.meucardapioseguro.services.ProductService;
import com.example.meucardapioseguro.exception.ProductNotFoundException;
import com.example.meucardapioseguro.exception.InvalidProductException;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public boolean addProduct(Product product) {
        try {
            return productService.addProduct(product);
        } catch (InvalidProductException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Product getProductById(Long id) {
        try {
            return productService.getProductById(id);
        } catch (ProductNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public boolean removeProductById(Long id) {
        try {
            return productService.removeProductById(id);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        try {
            return productService.updateProduct(product);
        } catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}

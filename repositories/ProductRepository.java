package com.example.meucardapioseguro.repositories;

import com.example.meucardapioseguro.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Long, Product> productMap;

    public ProductRepository() {
        this.productMap = new HashMap<>();
    }

    public boolean save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        productMap.put(product.getId(), product);
        return true;
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public boolean delete(Long id) {
        return productMap.remove(id) != null;
    }

    public Map<Long, Product> findAll() {
        return productMap;
    }
}

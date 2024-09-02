package com.example.meucardapioseguro.services;

import com.example.meucardapioseguro.model.Product;
import com.example.meucardapioseguro.exception.ProductNotFoundException;
import com.example.meucardapioseguro.exception.InvalidProductException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    private final Map<Long, Product> productMapById;
    private long currentId;

    public ProductService() {
        this.productMapById = new HashMap<>();
        this.currentId = 1L;
    }

    // Adiciona um novo produto
    public synchronized boolean addProduct(Product product) throws InvalidProductException {
        if (product == null || product.getName() == null || product.getBarcode() == null) {
            throw new InvalidProductException("Produto inválido. Verifique se todos os campos obrigatórios estão preenchidos.");
        }
        product.setId(currentId++);
        productMapById.put(product.getId(), product);
        return true;
    }

    // Obtém um produto por ID
    public synchronized Product getProductById(Long id) throws ProductNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        Product product = productMapById.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Produto não encontrado com o ID: " + id);
        }
        return product;
    }

    // Lista todos os produtos
    public synchronized List<Product> getAllProducts() {
        return new ArrayList<>(productMapById.values());
    }

    // Remove um produto por ID
    public synchronized boolean removeProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        Product product = productMapById.remove(id);
        return product != null;
    }

    // Atualiza informações de um produto
    public synchronized boolean updateProduct(Product product) throws ProductNotFoundException {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Produto ou ID não pode ser nulo.");
        }
        if (!productMapById.containsKey(product.getId())) {
            throw new ProductNotFoundException("Produto não encontrado com o ID: " + product.getId());
        }
        productMapById.put(product.getId(), product);
        return true;
    }
}

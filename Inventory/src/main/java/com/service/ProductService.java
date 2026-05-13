package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Product;
import com.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Save a new product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
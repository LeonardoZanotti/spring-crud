/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardozanotti.springcrud.service;

import com.leonardozanotti.springcrud.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author leonardozanotti
 */

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
    
    public List<Product> getProducts() {
        return repository.findAll();
    }
    
    public Product getProductById(int productId) {
        return repository.findById(productId).orElse(other: null);
    }
    
    public Product getProductByName(String productName) {
        return repository.findByName(productName).orElse(other: null);
    }
    
    public String deleteProduct(int productId) {
        repository.deleteById(productId);
        return "Product removed successfully " + productId;
    }
    
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(other: null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}

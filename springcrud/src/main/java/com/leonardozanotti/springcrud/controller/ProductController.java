/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardozanotti.springcrud.controller;

import com.leonardozanotti.springcrud.entity.Product;
import com.leonardozanotti.springcrud.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * @author leonardozanotti
 */

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    
    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    
    @PostMapping("/add-products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }
    
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/product-by-id/{productId}")
    public Product findProductById(@PathVariable int productId) {
        return service.getProductById(productId);
    }
    
    @GetMapping("/product-by-name/{productName}")
    public Product findProductByName(@PathVariable String productName) {
        return service.getProductByName(productName);
    }
    
    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    
    @DeleteMapping(value = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteProduct(@PathVariable int productId) {
        return service.deleteProduct(productId);
    }
}

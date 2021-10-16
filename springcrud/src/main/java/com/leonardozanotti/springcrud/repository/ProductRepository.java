/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.leonardozanotti.springcrud.repository;

import com.leonardozanotti.springcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author leonardozanotti
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}

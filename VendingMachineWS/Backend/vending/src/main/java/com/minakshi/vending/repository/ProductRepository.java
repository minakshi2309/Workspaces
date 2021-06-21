package com.minakshi.vending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minakshi.vending.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

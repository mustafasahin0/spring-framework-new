package com.example.repository;


import com.example.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository{
    public boolean addCartDatabase(Product product, int quantity) {
        System.out.println(product.getName() + " is added to database");
        return true;
    }
}

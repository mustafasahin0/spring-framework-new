package com.example.repository;

import com.example.entity.Product;

public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}

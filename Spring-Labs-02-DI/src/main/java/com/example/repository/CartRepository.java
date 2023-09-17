package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Service;

public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}

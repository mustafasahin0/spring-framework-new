package com.example.service;

import com.example.entity.Cart;
import com.example.entity.Product;

public interface CartService {
    Cart addCart(Product product, int quantity);
}

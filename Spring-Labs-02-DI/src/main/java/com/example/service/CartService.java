package com.example.service;

import com.example.model.Cart;
import com.example.model.Product;

public interface CartService {
    Cart addCart(Product product, int quantity);
}

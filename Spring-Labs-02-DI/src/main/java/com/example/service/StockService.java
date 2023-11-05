package com.example.service;

import com.example.entity.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}

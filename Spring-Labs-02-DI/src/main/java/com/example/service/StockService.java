package com.example.service;

import com.example.model.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}

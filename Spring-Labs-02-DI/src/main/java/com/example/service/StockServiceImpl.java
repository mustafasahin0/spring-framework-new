package com.example.service;

import com.example.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }
}

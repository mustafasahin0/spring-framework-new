package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }
}

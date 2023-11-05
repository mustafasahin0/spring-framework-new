package com.example;

import com.example.config.ConfigApp;
import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.repository.CartRepository;
import com.example.service.CartServiceImpl;
import com.example.service.StockService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith( SpringRunner.class )
@ContextConfiguration(classes = ConfigApp.class)
public class CartServiceTest {

    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockService stockService;


    @Test
    public void addCartTest(){
        Product product = new Product();
        product.setName("milk");
        product.setPrice(new BigDecimal(12));
        product.setQuantity(3);
        product.setRemainingQuantity(3);
        Cart cart = cartService.addCart(product, 2);
        Assert.assertEquals(new BigDecimal(24), cart.getCartTotalAmount());
    }
}

package com.example.bootstrap;

import com.example.enums.Status;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository  itemRepository;
    private final CartRepository cartRepository;


    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(new BigDecimal("150000"), LocalDate.of(2023, 4, 19), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("14000"), new BigDecimal("10000"), LocalDate.of(2023, 4, 24));

        payment1.setPaymentDetail(paymentDetail1);


        Payment payment2 = new Payment(new BigDecimal("10000"), LocalDate.of(2023, 5, 20), Status.SUCCESS);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("18000"), new BigDecimal("12000"), LocalDate.of(2023, 2, 24));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerchant", "M123", new BigDecimal("0.25"), new BigDecimal("3.25"), 5);

        Customer customer1 = new Customer("VA", "msmith@example.com", "Mike", "Smith", "msmith");


        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        Item item1 = new Item("Milk", "M01");
        Item item2 = new Item("Sugar", "S01");
        Item item3 = new Item("Bread", "B01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setItemList(Arrays.asList(item1, item2, item3));
        cart2.setItemList(Arrays.asList(item1, item2));

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        customerRepository.save(customer1);

        merchantRepository.save(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}

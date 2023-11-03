package com.example.bootstrap;

import com.example.enums.Status;
import com.example.model.Customer;
import com.example.model.Merchant;
import com.example.model.Payment;
import com.example.model.PaymentDetail;
import com.example.repository.CustomerRepository;
import com.example.repository.MerchantRepository;
import com.example.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private PaymentRepository paymentRepository;
    private MerchantRepository merchantRepository;
    private CustomerRepository customerRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
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

        customerRepository.save(customer1);

        merchantRepository.save(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}

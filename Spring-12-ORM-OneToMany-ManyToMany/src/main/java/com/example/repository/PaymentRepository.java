package com.example.repository;

import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // derive query = select * from payment where id = ?

    // sql @Query

    // JPQL @Query
}

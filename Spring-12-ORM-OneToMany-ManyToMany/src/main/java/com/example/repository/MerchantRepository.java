package com.example.repository;

import com.example.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}

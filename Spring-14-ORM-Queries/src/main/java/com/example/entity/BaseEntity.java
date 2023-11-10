package com.example.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
public class BaseEntity {
    @Id
    private Long id;
}

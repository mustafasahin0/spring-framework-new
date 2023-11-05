package com.example.entity;

import com.example.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Location extends BaseEntity {

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String postalCode;
    private String country;
    private String city;
    private String state;
    private String address;



}

package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity {

    private String region;
    private String country;

    @OneToOne(mappedBy = "region")
    private Employee employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}

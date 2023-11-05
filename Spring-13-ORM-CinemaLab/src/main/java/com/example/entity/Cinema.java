package com.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    private Location location;

}

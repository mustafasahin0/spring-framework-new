package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Item extends BaseEntity{

    private String name;
    private String code;

    @ManyToMany
    private List<Cart> cartList;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}

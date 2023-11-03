package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity {

    @ManyToMany
    private List<Item> itemList;
}

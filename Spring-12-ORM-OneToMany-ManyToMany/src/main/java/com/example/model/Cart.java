package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity {

    @ManyToMany
    @JoinTable(name = "cart_items_rel", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name = "i_id"))
    @OrderBy("id ASC")
    @Column(nullable = false)
    private List<Item> itemList;
}

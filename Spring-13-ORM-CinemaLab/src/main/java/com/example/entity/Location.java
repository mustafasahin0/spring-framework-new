package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
public class Location extends BaseEntity {

    private String name;
    private String address;
    private int postalCode;
    private String country;
    private String state;
    private String city;

    @OneToMany(mappedBy = "locationId")
    private List<Cinema> cinemaList;

    public Location(String name, String address, int postalCode, String country, String state, String city) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
    }
}

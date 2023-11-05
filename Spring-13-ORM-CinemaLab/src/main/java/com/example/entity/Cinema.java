package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cinema")
@Data
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @OneToMany(mappedBy = "cinema")
    private List<MovieCinema> movieCinemaList;

    @ManyToOne
    private Location locationId;

    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }
}

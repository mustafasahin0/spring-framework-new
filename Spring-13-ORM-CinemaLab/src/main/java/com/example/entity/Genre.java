package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
public class Genre extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;
}

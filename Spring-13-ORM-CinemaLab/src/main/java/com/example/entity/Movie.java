package com.example.entity;

import com.example.enums.State;
import com.example.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Data
public class Movie extends BaseEntity{

    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private int duration;
    private String summary;

    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinemaList;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
}

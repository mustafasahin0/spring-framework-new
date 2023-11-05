package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie_cinema")
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticketList;

    @ManyToOne
    private Cinema cinema;
    @ManyToOne
    private Movie movie;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

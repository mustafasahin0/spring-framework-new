package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    private int seatNumber;
    private int rowNumber;

    @ManyToOne
    private UserAccount userAccount;

    @ManyToOne
    private MovieCinema movieCinema;

    public Ticket(LocalDateTime dateTime, int seatNumber, int rowNumber) {
        this.dateTime = dateTime;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
    }
}

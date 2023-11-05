package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    private String seatNumber;
    private Integer rowNumber;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userAccount;
}

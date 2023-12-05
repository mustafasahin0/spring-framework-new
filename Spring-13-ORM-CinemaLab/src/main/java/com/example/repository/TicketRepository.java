package com.example.repository;

import com.example.entity.Movie;
import com.example.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countAllByUserAccount();
    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    int countAllByMovieCinemaMovie(Movie movie);
    //Write a derived query to list all tickets between a range of dates

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user

    //Write a JPQL query that returns all tickets between a range of dates

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    //Write a native query to count the number of tickets a user bought in a specific range of dates

    //Write a native query to distinct all tickets by movie name

    //Write a native query to find all tickets by user email

    //Write a native query that returns all tickets

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

}
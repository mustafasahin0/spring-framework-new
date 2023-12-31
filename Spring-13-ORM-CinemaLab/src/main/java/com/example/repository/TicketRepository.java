package com.example.repository;

import com.example.entity.Movie;
import com.example.entity.Ticket;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countAllByUserAccountId(Long userId);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    int countAllByMovieCinema_Movie_Name(String movieName);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime localDateTime1, LocalDateTime localDateTime2);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.email = ?1")
    List<Ticket> findAllByUser(String userEmail);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t from Ticket t WHERE t.dateTime between ?1 AND ?2")
    List<Ticket> findAllByDates(LocalDateTime localDateTime1, LocalDateTime localDateTime2);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT COUNT(*) FROM Ticket t WHERE t.userAccount.id = ?1", nativeQuery = true)
    int countTicketByUser(Long userId);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM Ticket t WHERE date_time BETWEEN ?1 AND ?2", nativeQuery = true)
    Integer fetchAllTicketsBetweenRangeOfDateTimes(LocalDateTime localDateTime1, LocalDateTime localDateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT m.Name FROM Ticket t JOIN movie_cinema mc ON t.movie_cinema_id = mc.id JOIN movie", nativeQuery = true)
    List<String> retrieveAllDistinctMovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM Ticket t JOIN user_account ua ON t.user_account_id = ua.id WHERE ua.id = ?1", nativeQuery = true)
    List<Ticket> fetchAllTicketsByUserAccount(Long id);
    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM Ticket", nativeQuery = true)
    List<Ticket> findAllTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM Ticket t JOIN USER u ON t.user.iserId = u.id JOIN movie_cinema mc ON t.movieCinemaId = mc.id JOIN Movie m ON mc.Movie.movieId = m.id WHERE u.Username ILIKE CONCAT('%', ?1, '%') OR m.movieName ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String pattern);
}
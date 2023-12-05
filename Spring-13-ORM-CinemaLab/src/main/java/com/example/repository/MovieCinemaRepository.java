package com.example.repository;

import com.example.entity.Cinema;
import com.example.entity.Location;
import com.example.entity.Movie;
import com.example.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);
    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);
    //Write a derived query to count all movie cinemas with a specific movie id
    List<MovieCinema> findAllByMovie(Movie movie);
    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime localDateTime);
    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();
    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String movieName);
    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinema_Location_Name(String name);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query(value = "SELECT mc FROM MovieCinema mc WHERE mc.dateTime > :dateTime", nativeQuery = false)
    List<MovieCinema> listAllByDateGreaterThan(@Param("dateTime") LocalDateTime localDateTime);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT count(*) FROM MOVIE_CINEMA", nativeQuery = true)
    List<MovieCinema> countAllMovieCinemas();
    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM MOVIE_CINEMA ms INNER JOIN LOCATION l ON ms.location_id = l.id WHERE l.name = :locationName", nativeQuery = true)
    List<MovieCinema> getAllByLocationName(@Param("locationName") String locationName);
}
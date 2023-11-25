package com.example.repository;

import com.example.entity.Movie;
import com.example.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Movie getMovieBy(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> getAllByPriceBetween(BigDecimal price1, BigDecimal price2);
    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> getMovieByDurationIn(List<Integer> duration);
    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> getAllByReleaseDateGreaterThan(LocalDate localDate);
    //Write a derived query to list all movies with a specific state and type
    List<Movie> getAllByStateAndType(String state, MovieType movieType);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query(value = "SELECT m FROM Movie m WHERE m.price BETWEEN :price1 AND :price2")
    List<Movie> getAllByPriceBetweenPrices(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);
    //Write a JPQL query that returns all movie names
    @Query(value = "SELECT m.name FROM Movie m")
    List<String> getAllMovieNames();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM MOVIE WHERE NAME = :name", nativeQuery = true)
    Movie getMovieByName(@Param("name") String name);
    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM MOVIE WHERE PRICE BETWEEN :price1 AND :price2", nativeQuery = true)
    List<Movie> getByPriceBetween(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);
    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM MOVIE WHERE DURATION IN :durationList", nativeQuery = true)
    List<Movie> getAllMoviesInDuration(@Param("durationList") List<Integer> durationList);
    //Write a native query to list the top 5 most expensive movies

}
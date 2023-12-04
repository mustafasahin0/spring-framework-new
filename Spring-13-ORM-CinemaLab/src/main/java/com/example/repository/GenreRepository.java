package com.example.repository;

import com.example.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("SELECT g FROM Genre g")
    List<Genre> findAllGenres();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "SELECT * FROM GENRE g WHERE g.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> getAllByNameContaining(@Param("pattern") String pattern);
}
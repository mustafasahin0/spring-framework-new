package com.example.repository;

import com.example.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    List<Cinema> getAllByName(String name);
    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> getTop3BySponsoredNameContaining(String pattern);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema> getAllByLocationCountry(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> getAllByNameOrSponsoredName(String name, String sponsoredName);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query(value = "SELECT c FROM Cinema c WHERE c.name =:name AND c.id = :id")
    List<Cinema> getAllByNameWithId(@Param("name") String name, @Param("id") Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM CINEMA c INNER JOIN LOCATION l ON c.location_id = l.id WHERE l.country = :country", nativeQuery = true)
    List<Cinema> getAllCinemasByLocationCountry(@Param("country") String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM CINEMA WHERE name LIKE %:name% OR sponsored_name LIKE %:pattern%", nativeQuery = true)
    List<Cinema> getAllCinemasByNameOrSponsoredNameContaining(@Param("name") String name, @Param("pattern") String pattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM CINEMA c ORDER BY c.name", nativeQuery = true)
    List<Cinema> sortAllByName();
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT DISTINCT FROM CINEMA WHERE sponsored_name IS LIKE :name", nativeQuery = true)
    List<Cinema> getAllDistinctName(@Param("name") String name);
}
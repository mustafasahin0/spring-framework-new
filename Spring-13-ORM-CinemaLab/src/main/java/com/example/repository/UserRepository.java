package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    User findByEmail(String email);

    //Write a derived query to read a user with an username?
    User findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccount_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User listUserByEmail(String email);
    //Write a JPQL query that returns a user read by username?

    @Query("SELECT u FROM User u WHERE u.userName=?1")
    User listUserName(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> allUser();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM User u WHERE u.username ILIKE  CONCAT('%', ?1, '%')", nativeQuery = true)
    List<User> getAllUsersByName(String name);

    //Write a native query that returns all users?
    @Query(value = "SELECT u FROM User u", nativeQuery = true)
    List<User> listAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM USER WHERE age is BETWEEN ?1 and ?2", nativeQuery = true)
    List<User> getAllUserByAgeBetween(int age1, int age2);
    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM USER WHERE email = ?1", nativeQuery = true)
    List<User> getAllByEmail(String email);

}
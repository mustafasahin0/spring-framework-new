package com.example.repository;

import com.example.entity.Account;
import com.example.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);
    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int age);
    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole userRole);
    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1, int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressIsStartingWith(String pattern);
    //Write a derived query to sort the list of accounts with age
    List<Account> findAllOrderByAge();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> getAllAccounts();
    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> getAllAdmins();
    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age")
    List<Account> sortAllByAges();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM ACCOUNTS WHERE AGE <= :age", nativeQuery = true)
    List<Account> getAccountsLessThanAge(@Param("age") int age);
    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM ACCOUNTS WHERE NAME LIKE :pattern OR ADDRESS LIKE :pattern OR COUNTRY LIKE :pattern OR STATE LIKE :pattern OR CITY LIKE :pattern", nativeQuery = true)
    List<Account> getAllAccountsContainsNameAddressCountryStateCity(@Param("pattern") String pattern);
    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM ACCOUNTS WHERE AGE <= :age", nativeQuery = true)
    List<Account> getAllAccountsLessThanAge(@Param("age") int age);

}
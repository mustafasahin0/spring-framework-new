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
    List<Account> findAllByCountryOrState(String country, String state);
    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(int age);
    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByRole(UserRole userRole);
    //Write a derived query to list all accounts between a range of ages
    List<Account> findAllByAgeBetween(int age1, int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String pattern);
    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOOrderByAgeDesc();
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
    @Query(value = "SELECT * FROM account_details WHERE age < :age", nativeQuery = true)
    List<Account> getAccountsLessThanAge(@Param("age") int age);
    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM ACCOUNT_DETAIlS WHERE NAME ILIKE concat('%', ?1, '%') OR ADDRESS ILIKE concat('%', ?1, '%') OR COUNTRY ILIKE concat('%', ?1, '%') OR STATE ILIKE concat('%', ?1, '%') OR CITY ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Account> getAllAccountsContainsNameAddressCountryStateCity(@Param("pattern") String pattern);
}
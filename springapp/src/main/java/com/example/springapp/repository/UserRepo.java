package com.example.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.User;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}

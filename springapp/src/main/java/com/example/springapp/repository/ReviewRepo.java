package com.example.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Review;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.court.id = :courtId")
    List<Review> findByCourt(@Param("courtId") Long courtId);

    @Query("SELECT r FROM Review r WHERE r.user.id = :userId")
    List<Review> findByUser(@Param("userId") Long userId);

    @Query("SELECT r FROM Review r WHERE r.rating = :rating")
    List<Review> findByRating(@Param("rating") int rating);

    Double findAverageRatingByCourtId(Long courtId);
}


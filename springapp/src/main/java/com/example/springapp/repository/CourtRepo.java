package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Court;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CourtRepo extends JpaRepository<Court, Long> {

    @Query("SELECT c FROM Court c WHERE c.type = :type")
    List<Court> findCourtsByType(@Param("type") String type);

    @Query("SELECT c FROM Court c WHERE c.location = :location")
    List<Court> findCourtsByLocation(@Param("location") String location);

    @Query("SELECT c FROM Court c WHERE c.available = true")
    List<Court> findAvailableCourts();

    List<Court> findByAvailableTrue();
}


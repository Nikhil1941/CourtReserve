package com.example.springapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.*;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    // Find bookings by User
    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId")
    List<Booking> findBookingsByUser(@Param("userId") Long userId);

    // Find bookings by Court
    @Query("SELECT b FROM Booking b WHERE b.court.id = :courtId")
    List<Booking> findBookingsByCourt(@Param("courtId") Long courtId);

    // Find overlapping bookings (for availability check)
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.court = :court AND b.startTime <= :end AND b.endTime >= :start")
    boolean existsOverlappingBooking(@Param("court") Court court,
                                     @Param("start") LocalDateTime start,
                                     @Param("end") LocalDateTime end);
}


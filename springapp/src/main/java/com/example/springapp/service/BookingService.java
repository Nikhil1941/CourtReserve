package com.example.springapp.service;

import com.example.springapp.model.Booking;
import com.example.springapp.model.Court;
import com.example.springapp.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    // JPQL → Get bookings by user
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepo.findBookingsByUser(userId);
    }

    // JPQL → Get bookings by court
    public List<Booking> getBookingsByCourt(Long courtId) {
        return bookingRepo.findBookingsByCourt(courtId);
    }

    // JPQL → Check if court is available (no overlapping bookings)
    public boolean isCourtAvailable(Court court, LocalDateTime start, LocalDateTime end) {
        return !bookingRepo.existsOverlappingBooking(court, start, end);
    }

    // Save a booking
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    // Get booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}

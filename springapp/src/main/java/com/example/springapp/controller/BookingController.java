package com.example.springapp.controller;

import com.example.springapp.model.Booking;
import com.example.springapp.model.Court;
import com.example.springapp.service.BookingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ✅ JPQL → Get bookings by user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    // ✅ JPQL → Get bookings by court
    @GetMapping("/court/{courtId}")
    public List<Booking> getBookingsByCourt(@PathVariable Long courtId) {
        return bookingService.getBookingsByCourt(courtId);
    }

    // ✅ JPQL → Check availability
    @GetMapping("/availability")
    public boolean checkCourtAvailability(@RequestParam Long courtId,
                                          @RequestParam String start,
                                          @RequestParam String end) {
        Court court = new Court();
        court.setId(courtId); // only ID is enough for availability check

        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);

        return bookingService.isCourtAvailable(court, startTime, endTime);
    }

    // ✅ Create new booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    // ✅ Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // ✅ Get booking by ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // ✅ Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}

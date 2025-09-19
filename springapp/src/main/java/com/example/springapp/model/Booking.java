    package com.example.springapp.model;

    import jakarta.persistence.*;
    import lombok.*;

    import java.time.LocalDateTime;
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDateTime bookingDate;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "court_id")   // Many bookings belong to one court
    private Court court;

    @ManyToOne
    @JoinColumn(name = "user_id")    // Many bookings belong to one user
    private User user;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;         // One booking has one payment
    }
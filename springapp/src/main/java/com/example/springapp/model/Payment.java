package com.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String transactionId;
    private String paymentMode; // UPI, Card, NetBanking
    private String status;      // SUCCESS, FAILED, PENDING
    private Double amount;

    @OneToOne
@JoinColumn(name = "booking_id", unique = true) 
@JsonManagedReference
@JsonIgnore
private Booking booking;   // One payment is linked to one booking
}

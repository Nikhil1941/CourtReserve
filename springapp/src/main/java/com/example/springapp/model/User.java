package com.example.springapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Booking> bookings;   // One user can have many bookings

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Review> reviews;     // One user can write many reviews

    
}

package com.example.springapp.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courtName;
    private String location;
    private String type;  // Tennis, Badminton, Football, etc.
    private boolean available;

    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
    @JsonIgnore
private List<Booking> bookings;   // One court can have many bookings

@OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
@JsonIgnore
private List<Review> reviews;     // One court can have many reviews

}

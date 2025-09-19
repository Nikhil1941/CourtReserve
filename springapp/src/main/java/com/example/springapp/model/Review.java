package com.example.springapp.model;

import jakarta.persistence.*;
import lombok.*;

//import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating; // 1-5 stars
    private String comment;

    @ManyToOne
@JoinColumn(name = "court_id")   // Many reviews belong to one court
private Court court;

@ManyToOne
@JoinColumn(name = "user_id")    // Many reviews belong to one user
private User user;

}
    


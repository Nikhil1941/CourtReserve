package com.example.springapp.controller;

import com.example.springapp.model.Review;
import com.example.springapp.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return service.getReviewById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.createReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return ResponseEntity.ok(service.updateReview(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    // JPQL usage: find reviews by court
    @GetMapping("/court/{courtId}")
    public List<Review> getReviewsByCourt(@PathVariable Long courtId) {
        return service.getReviewsByCourt(courtId);
    }

    // JPQL usage: find reviews by user
    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUser(@PathVariable Long userId) {
        return service.getReviewsByUser(userId);
    }

    // JPQL usage: find reviews by rating
    @GetMapping("/rating/{rating}")
    public List<Review> getReviewsByRating(@PathVariable int rating) {
        return service.getReviewsByRating(rating);
    }

    // JPQL usage: get average rating for a court
    @GetMapping("/court/{courtId}/average-rating")
    public Double getAverageRatingForCourt(@PathVariable Long courtId) {
        return service.getAverageRatingForCourt(courtId);
    }
    @GetMapping("/page")
public Page<Review> getPaginatedReviews(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
) {
    Pageable pageable = PageRequest.of(page, size);
    return service.getPaginatedReviews(pageable);
}
}

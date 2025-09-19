package com.example.springapp.service;

import com.example.springapp.model.Review;
import com.example.springapp.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private final ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    // ✅ Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    // ✅ Get review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepo.findById(id);
    }

    // ✅ Create new review
    public Review createReview(Review review) {
        return reviewRepo.save(review);
    }

    // ✅ Update review safely
    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepo.findById(id).map(review -> {
            review.setRating(updatedReview.getRating());
            review.setComment(updatedReview.getComment());
            review.setCourt(updatedReview.getCourt());
            review.setUser(updatedReview.getUser());
            return reviewRepo.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found with id " + id));
    }

    // ✅ Delete review
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    
    // JPQL: Find reviews by court ID
    public List<Review> getReviewsByCourt(Long courtId) {
        return reviewRepo.findByCourt(courtId);
    }

    // JPQL: Find reviews by user ID
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepo.findByUser(userId);
    }

    // JPQL: Find reviews by rating
    public List<Review> getReviewsByRating(int rating) {
        return reviewRepo.findByRating(rating);
    }

    // JPQL: Find average rating for a court
    public Double getAverageRatingForCourt(Long courtId) {
        return reviewRepo.findAverageRatingByCourtId(courtId);
    }
    // Get paginated reviews
public Page<Review> getPaginatedReviews(Pageable pageable) {
    return reviewRepo.findAll(pageable);
}
}

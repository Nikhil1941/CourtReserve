package com.example.springapp.service;

import com.example.springapp.model.Court;
import com.example.springapp.repository.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    @Autowired
    private CourtRepo courtRepo;

    // ✅ Get all courts
    public List<Court> getAllCourts() {
        return courtRepo.findAll();
    }

    // ✅ Get court by id
    public Optional<Court> getCourtById(Long id) {
        return courtRepo.findById(id);
    }

    // ✅ Create new court
    public Court createCourt(Court court) {
        return courtRepo.save(court);
    }

    // ✅ Update existing court
    public Court updateCourt(Long id, Court updatedCourt) {
        return courtRepo.findById(id).map(court -> {
            court.setCourtName(updatedCourt.getCourtName());
            court.setLocation(updatedCourt.getLocation());
            court.setType(updatedCourt.getType());
            court.setAvailable(updatedCourt.isAvailable());
            return courtRepo.save(court);
        }).orElseThrow(() -> new RuntimeException("Court not found with id " + id));
    }

    // ✅ Delete court safely
    public void deleteCourt(Long id) {
        if (!courtRepo.existsById(id)) {
            throw new RuntimeException("Court not found with id " + id);
        }
        courtRepo.deleteById(id);
    }

    // ✅ Find courts by location (JPQL)
    public List<Court> getCourtsByLocation(String location) {
        return courtRepo.findCourtsByLocation(location);
    }

    // ✅ Find courts by type (JPQL)
    public List<Court> getCourtsByType(String type) {
        return courtRepo.findCourtsByType(type);
    }

    // ✅ Find available courts (JPQL)
    public List<Court> getAvailableCourts() {
        return courtRepo.findByAvailableTrue();
    }

    // ✅ Find courts by name (extra useful search)
    public List<Court> getCourtsByName(String courtName) {
        return courtRepo.findCourtsByType(courtName);
    }

    // ✅ Toggle availability (extra feature)
    public Court toggleAvailability(Long id) {
        return courtRepo.findById(id).map(court -> {
            court.setAvailable(!court.isAvailable());
            return courtRepo.save(court);
        }).orElseThrow(() -> new RuntimeException("Court not found with id " + id));
    }
}

package com.example.springapp.controller;

import com.example.springapp.model.Court;
import com.example.springapp.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courts")
public class CourtController {

    @Autowired
    private CourtService courtService;

    // ✅ Get all courts
    @GetMapping
    public List<Court> getAllCourts() {
        return courtService.getAllCourts();
    }

    // ✅ Get court by ID
    @GetMapping("/{id}")
    public Optional<Court> getCourtById(@PathVariable Long id) {
        return courtService.getCourtById(id);
    }

    // ✅ Create new court
    @PostMapping
    public Court createCourt(@RequestBody Court court) {
        return courtService.createCourt(court);
    }

    // ✅ Update court
    @PutMapping("/{id}")
    public Court updateCourt(@PathVariable Long id, @RequestBody Court court) {
        return courtService.updateCourt(id, court);
    }

    // ✅ Delete court
    @DeleteMapping("/{id}")
    public void deleteCourt(@PathVariable Long id) {
        courtService.deleteCourt(id);
    }

    // ✅ Get courts by location
    @GetMapping("/location/{location}")
    public List<Court> getCourtsByLocation(@PathVariable String location) {
        return courtService.getCourtsByLocation(location);
    }

    // ✅ Get courts by type
    @GetMapping("/type/{type}")
    public List<Court> getCourtsByType(@PathVariable String type) {
        return courtService.getCourtsByType(type);
    }

    // ✅ Get available courts
    @GetMapping("/available")
    public List<Court> getAvailableCourts() {
        return courtService.getAvailableCourts();
    }

    // ✅ Get courts by name
    @GetMapping("/name/{courtName}")
    public List<Court> getCourtsByName(@PathVariable String courtName) {
        return courtService.getCourtsByName(courtName);
    }

    // ✅ Toggle availability (on/off)
    @PatchMapping("/{id}/toggle-availability")
    public Court toggleCourtAvailability(@PathVariable Long id) {
        return courtService.toggleAvailability(id);
    }
}

package com.example.springapp.controller;

import com.example.springapp.model.Payment;
import com.example.springapp.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    // Constructor injection
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return service.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new payment
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return service.createPayment(payment);
    }

    // Update existing payment
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return ResponseEntity.ok(service.updatePayment(payment));
    }

    // Delete payment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    // JPQL usage: find payment by transactionId
   @GetMapping("/transaction/{txnId}")
public ResponseEntity<List<Payment>> getPaymentsByTransactionId(@PathVariable String txnId) {
    List<Payment> payments = service.getPaymentsByTransactionId(txnId);
    if (payments.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(payments);
}


    // JPQL usage: count payments by status
    @GetMapping("/status/{status}/count")
    public long countPaymentsByStatus(@PathVariable String status) {
        return service.countPaymentsByStatus(status);
    }
}

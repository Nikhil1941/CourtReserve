package com.example.springapp.service;

import com.example.springapp.model.*;
import com.example.springapp.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

     // JPQL: Find payment by transactionId
   public List<Payment> getPaymentsByTransactionId(String txnId) {
    return paymentRepo.findByTransactionId(txnId);
}


    // JPQL: Count payments by status
    public long countPaymentsByStatus(String status) {
        return paymentRepo.findByStatus(status);
    }
}

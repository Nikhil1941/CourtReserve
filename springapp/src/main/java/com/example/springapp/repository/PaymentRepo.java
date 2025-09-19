package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Payment;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.transactionId = :txnId")
List<Payment> findByTransactionId(@Param("txnId") String txnId);


    @Query("SELECT p FROM Payment p WHERE p.status = :status")
    long findByStatus(@Param("status") String status);
}

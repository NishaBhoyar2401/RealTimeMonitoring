package com.demo.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.monitoring.model.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, String>{

}

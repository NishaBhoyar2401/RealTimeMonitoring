package com.demo.monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.monitoring.model.Transaction;
import com.demo.monitoring.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction getTransaction(String id) {
        return repository.findById(id).orElse(null);
    }
}

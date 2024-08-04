package com.demo.monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.monitoring.model.Transaction;
import com.demo.monitoring.service.FraudDetectionService;
import com.demo.monitoring.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	@Autowired
    private TransactionService transactionService;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping
    public String addTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
        boolean isFraud = fraudDetectionService.detectFraud(transaction);
        return isFraud ? "Fraud detected" : "Transaction processed";
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable String id) {
        return transactionService.getTransaction(id);
    }
}

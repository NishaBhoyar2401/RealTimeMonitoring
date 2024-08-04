package com.demo.monitoring.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
  
	@Id
    private String transactionId;
    private double amount;
    private String currency;
    private LocalDateTime timestamp;
    private String location;
    private String device;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public Transaction(String transactionId, double amount, String currency, LocalDateTime timestamp, String location,
			String device) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.currency = currency;
		this.timestamp = timestamp;
		this.location = location;
		this.device = device;
	}
	public Transaction() {
		super();
	}
    
    
}

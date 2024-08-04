package com.demo.monitoring.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.monitoring.model.Transaction;

@Service
public class TransactionConsumerService {
	
	@Autowired
    private KafkaConsumer<String, String> consumer;

    @Autowired
    private TransactionService transactionService;

    @KafkaListener(topics = "transactions", groupId = "transaction_group")
    public void listen(ConsumerRecord<String, String> record) {
        // Deserialize the transaction object and save it
        Transaction transaction = deserialize(record.value());
        transactionService.saveTransaction(transaction);
    }

    private Transaction deserialize(String data) {
        // Implement deserialization logic
        return new Transaction();
    }

}

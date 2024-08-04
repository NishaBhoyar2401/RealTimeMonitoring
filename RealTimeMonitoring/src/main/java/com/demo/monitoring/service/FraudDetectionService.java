package com.demo.monitoring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.demo.monitoring.model.Transaction;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

import weka.core.Instances;
@Service
public class FraudDetectionService {
	private Classifier model;

    public FraudDetectionService() {
        try {
            // Load a pre-trained model from file
            model = (Classifier) weka.core.SerializationHelper.read("fraud_model.model");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean detectFraud(Transaction transaction) {
        try {
            ArrayList<Attribute> attributes = new ArrayList<>();
            attributes.add(new Attribute("amount"));
            attributes.add(new Attribute("location", (ArrayList<String>) null));
            attributes.add(new Attribute("device", (ArrayList<String>) null));
            Instances data = new Instances("TransactionData", attributes, 0);
            data.setClassIndex(0);

            Instance instance = new DenseInstance(3);
            instance.setValue(attributes.get(0), transaction.getAmount());
            instance.setValue(attributes.get(1), transaction.getLocation());
            instance.setValue(attributes.get(2), transaction.getDevice());
            data.add(instance);

            double result = model.classifyInstance(data.firstInstance());
            return result == 1.0;  // Assuming 1.0 is fraud
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
}

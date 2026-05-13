package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Alerts;
import com.repository.AlertRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // Get all alerts
    public List<Alerts> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Get alert by ID
    public Optional<Alerts> getAlertById(Integer id) {
        return alertRepository.findById(id);
    }

    // Save a new alert
    public Alerts saveAlert(Alerts alert) {
        return alertRepository.save(alert);
    }

    // Update an existing alert
    public Alerts updateAlert(Alerts alert) {
        return alertRepository.save(alert);
    }

    // Delete an alert by ID
    public void deleteAlert(Integer id) {
        alertRepository.deleteById(id);
    }
}
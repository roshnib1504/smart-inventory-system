package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.Alerts;
import com.service.AlertService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AlertController {

    @Autowired
    private AlertService alertService;

    // Get all alerts
    @GetMapping
    public List<Alerts> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    // Get alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<Alerts> getAlertById(@PathVariable Integer id) {
        Optional<Alerts> alert = alertService.getAlertById(id);
        return alert.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new alert (though alerts are normally triggered automatically)
    @PostMapping
    public Alerts createAlert(@RequestBody Alerts alert) {
        return alertService.saveAlert(alert);
    }

    // Update an alert
    @PutMapping("/{id}")
    public ResponseEntity<Alerts> updateAlert(@PathVariable Integer id, @RequestBody Alerts alertDetails) {
        Optional<Alerts> alert = alertService.getAlertById(id);
        if (alert.isPresent()) {
            Alerts existingAlert = alert.get();
            existingAlert.setAlertType(alertDetails.getAlertType());
            existingAlert.setAlertMessage(alertDetails.getAlertMessage());
            existingAlert.setResolved(alertDetails.getResolved());
            return ResponseEntity.ok(alertService.updateAlert(existingAlert));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an alert
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Integer id) {
        if (alertService.getAlertById(id).isPresent()) {
            alertService.deleteAlert(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
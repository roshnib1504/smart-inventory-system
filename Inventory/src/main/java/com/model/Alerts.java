package com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alerts")
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "alert_type", length = 50)
    private String alertType;

    @Column(name = "alert_message", length = 255)
    private String alertMessage;

    @Column(name = "alert_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime alertDate;

    @Column(name = "resolved", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean resolved;

    // Constructors
    public Alerts() {
    }

    public Alerts(Integer productId, Integer inventoryId, String alertType, String alertMessage, Boolean resolved) {
        this.productId = productId;
        this.inventoryId = inventoryId;
        this.alertType = alertType;
        this.alertMessage = alertMessage;
        this.resolved = resolved;
    }

    // Getters and Setters
    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
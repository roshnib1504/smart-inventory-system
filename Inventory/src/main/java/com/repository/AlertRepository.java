package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Alerts;

@Repository
public interface AlertRepository extends JpaRepository<Alerts, Integer> {
    // You can add custom queries here if needed
}
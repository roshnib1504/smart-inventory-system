package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Inventory;
import com.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Get all inventory records
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Get inventory by ID
    public Optional<Inventory> getInventoryById(Integer id) {
        return inventoryRepository.findById(id);
    }

    // Save a new inventory record
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Update an existing inventory record
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Delete an inventory record by ID
    public void deleteInventory(Integer id) {
        inventoryRepository.deleteById(id);
    }
}
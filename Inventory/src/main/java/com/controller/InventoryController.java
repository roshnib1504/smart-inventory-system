package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.Inventory;
import com.service.InventoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	// Get all inventory records
	@GetMapping
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventory();
	}

	// Get inventory by ID
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Integer id) {
		Optional<Inventory> inventory = inventoryService.getInventoryById(id);
		return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Create a new inventory record
	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return inventoryService.saveInventory(inventory);
	}

	// Update an existing inventory record
	@PutMapping("/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable Integer id,
			@RequestBody Inventory inventoryDetails) {
		Optional<Inventory> inventory = inventoryService.getInventoryById(id);
		if (inventory.isPresent()) {
			Inventory existingInventory = inventory.get();
			existingInventory.setProductId(inventoryDetails.getProductId());
			existingInventory.setBatchNo(inventoryDetails.getBatchNo());
			existingInventory.setManufactureDate(inventoryDetails.getManufactureDate());
			existingInventory.setExpiryDate(inventoryDetails.getExpiryDate());
			existingInventory.setQuantity(inventoryDetails.getQuantity());
			existingInventory.setWarehouseLocation(inventoryDetails.getWarehouseLocation());
			return ResponseEntity.ok(inventoryService.updateInventory(existingInventory));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete an inventory record
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
		if (inventoryService.getInventoryById(id).isPresent()) {
			inventoryService.deleteInventory(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
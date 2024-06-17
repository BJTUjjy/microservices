package com.example.warehouse.service;

import com.example.warehouse.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehouse.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public boolean isProductAvailable(String itemId, int quantity) {
		return inventoryRepository.findById(itemId)
				.map(inventory -> inventory.getQuantity() >= quantity)
				.orElse(false);
	}

	public void deductProduct(String itemId, int quantity) {
		inventoryRepository.findById(itemId).ifPresent(inventory -> {
			inventory.setQuantity(inventory.getQuantity() - quantity);
			inventoryRepository.save(inventory);
		});
	}

	public void addProduct(Inventory inventory) {
		inventoryRepository.save(inventory);
	}
}

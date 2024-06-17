package com.example.warehouse.repository;

import com.example.warehouse.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
package com.example.warehouse.controller;

import com.example.warehouse.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.model.WarehouseResponse;
import com.example.common.model.Order;

@RestController
public class WarehouseController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/warehouse")
	public WarehouseResponse handleWarehouse(@RequestBody Order order) {
		// 校验订单中的商品是否存在以及数量是否足够
		if (inventoryService.isProductAvailable(order.getItemId(), order.getQuantity())) {
			inventoryService.deductProduct(order.getItemId(), order.getQuantity());
			return new WarehouseResponse("Warehouse processed for order: " + order.getItemId(), "SUCCESS");
		} else {
			return new WarehouseResponse("Insufficient inventory for order: " + order.getItemId(), "FAILED");
		}
	}
}

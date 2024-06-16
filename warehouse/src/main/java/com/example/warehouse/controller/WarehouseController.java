package com.example.warehouse.controller;

import com.example.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

	@PostMapping("/warehouse")
	public String handleWarehouse(@RequestBody Order order) {
		// 处理仓库逻辑
		return "Warehouse handled for order: " + order.getItemId();
	}
}




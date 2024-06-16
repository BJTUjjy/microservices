package com.example.logistic.controller;

import com.example.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticController {

	@PostMapping("/logistics")
	public String handleLogistics(@RequestBody Order order) {
		// 处理物流逻辑
		return "Logistics handled for order: " + order.getItemId();
	}
}


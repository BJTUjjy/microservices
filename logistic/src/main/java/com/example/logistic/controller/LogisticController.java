package com.example.logistic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.model.LogisticResponse;
import com.example.common.model.Order;

@RestController
public class LogisticController {

	@PostMapping("/logistics")
	public LogisticResponse handleLogistics(@RequestBody Order order) {
		//模拟故障
		if ("simulateFailure".equals(order.getItemId())) {
			throw new RuntimeException("Simulated failure");
		}
		return new LogisticResponse("Logistics processed for order: " + order.getItemId(), "SUCCESS");
	}
}

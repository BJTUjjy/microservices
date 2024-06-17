package com.example.crm.controller;

import com.example.common.model.Order;
import com.example.crm.service.CRMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private CRMService crmService;

	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		return crmService.processOrder(order);
	}
}

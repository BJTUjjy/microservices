package com.example.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.model.PaymentResponse;
import com.example.common.model.Order;

@RestController
public class PaymentController {

	@PostMapping("/payment")
	public PaymentResponse handlePayment(@RequestBody Order order) {
		// 模拟支付处理逻辑
		return new PaymentResponse("Payment processed for order: " + order.getItemId(), "SUCCESS");
	}
}

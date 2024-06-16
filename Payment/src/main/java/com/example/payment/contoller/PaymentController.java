package com.example.payment.contoller;

import com.example.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@PostMapping("/payment")
	public String handlePayment(@RequestBody Order order) {
		// 处理支付逻辑
		return "Payment handled for order: " + order.getItemId();
	}
}



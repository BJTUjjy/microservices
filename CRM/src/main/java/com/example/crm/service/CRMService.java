package com.example.crm.service;

import com.example.crm.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CRMService {

	@Autowired
	private RestTemplate restTemplate;

	public String processOrder(Order order) {
		// 调用物流服务
		String logisticResponse = restTemplate.postForObject("http://logistic-service/logistics", order, String.class);

		// 调用仓库服务
		String warehouseResponse = restTemplate.postForObject("http://warehouse-service/warehouse", order, String.class);

		// 调用支付服务
		String paymentResponse = restTemplate.postForObject("http://payment-service/payment", order, String.class);

		return "Order processed: " + logisticResponse + ", " + warehouseResponse + ", " + paymentResponse;
	}
}


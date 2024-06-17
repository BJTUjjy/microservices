package com.example.crm.service;

import com.example.common.model.LogisticResponse;
import com.example.common.model.Order;
import com.example.common.model.PaymentResponse;
import com.example.common.model.WarehouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CRMService {

	@Autowired
	private RestTemplate restTemplate;

	public String processOrder(Order order) {
		try {
			// 调用物流服务
			LogisticResponse logisticResponse = restTemplate.postForObject("http://logistic-service/logistics", order, LogisticResponse.class);

			// 调用仓库服务
			WarehouseResponse warehouseResponse = restTemplate.postForObject("http://warehouse-service/warehouse", order, WarehouseResponse.class);

			// 调用支付服务
			PaymentResponse paymentResponse = restTemplate.postForObject("http://payment-service/payment", order, PaymentResponse.class);

			return "Order processed successfully: " + "\nLogistics: " + logisticResponse.getStatus() + "  "+logisticResponse.getMessage()+
					"\nWarehouse: " + warehouseResponse.getStatus() +  "  " + warehouseResponse.getMessage()+
					"\nPayment: " + paymentResponse.getStatus() + "  " + paymentResponse.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error processing order: " + e.getMessage();
		}
	}
}



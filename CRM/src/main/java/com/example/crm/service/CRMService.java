package com.example.crm.service;

import com.example.common.model.LogisticResponse;
import com.example.common.model.Order;
import com.example.common.model.PaymentResponse;
import com.example.common.model.WarehouseResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CRMService {

	@Autowired
	private RestTemplate restTemplate;

	@CircuitBreaker(name = "logisticService", fallbackMethod = "logisticFallback")
	public LogisticResponse callLogisticService(Order order) {
		return restTemplate.postForObject("http://logistic-service/logistics", order, LogisticResponse.class);
	}

	@CircuitBreaker(name = "warehouseService", fallbackMethod = "warehouseFallback")
	public WarehouseResponse callWarehouseService(Order order) {
		return restTemplate.postForObject("http://warehouse-service/warehouse", order, WarehouseResponse.class);
	}

	@CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
	public PaymentResponse callPaymentService(Order order) {
		return restTemplate.postForObject("http://payment-service/payment", order, PaymentResponse.class);
	}

	public String processOrder(Order order) {
		try {
			// 调用物流服务
			LogisticResponse logisticResponse = callLogisticService(order);

			// 调用仓库服务
			WarehouseResponse warehouseResponse = callWarehouseService(order);

			// 校验仓库处理结果
			if (!"SUCCESS".equals(warehouseResponse.getStatus())) {
				return "Order processing failed at warehouse: " + warehouseResponse.getMessage();
			}

			// 调用支付服务
			PaymentResponse paymentResponse = callPaymentService(order);

			return "Order processed successfully: " + "\nLogistics: " + logisticResponse.getStatus() + "  "+logisticResponse.getMessage()+
					"\nWarehouse: " + warehouseResponse.getStatus() +  "  " + warehouseResponse.getMessage()+
					"\nPayment: " + paymentResponse.getStatus() + "  " + paymentResponse.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error processing order: " + e.getMessage();
		}
	}

	public LogisticResponse logisticFallback(Order order, Throwable throwable) {
		return new LogisticResponse("Fallback for logistic service", "FAILED");
	}

	public WarehouseResponse warehouseFallback(Order order, Throwable throwable) {
		return new WarehouseResponse("Fallback for warehouse service", "FAILED");
	}

	public PaymentResponse paymentFallback(Order order, Throwable throwable) {
		return new PaymentResponse("Fallback for payment service", "FAILED");
	}
}




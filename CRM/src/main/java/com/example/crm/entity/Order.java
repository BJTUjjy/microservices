package com.example.crm.entity;

import lombok.Data;

@Data
public class Order {
	private String itemId;
	private int quantity;
	private String customerId;

}


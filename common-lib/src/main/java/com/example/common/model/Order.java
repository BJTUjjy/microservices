package com.example.common.model;

public class Order {
	private String itemId;

	private String itemName;
	private int quantity;

	private String customerId;

	public Order() {}

	public Order(String itemId, String itemName, int quantity, String customerId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.customerId = customerId;
	}

	// Getters and Setters
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}


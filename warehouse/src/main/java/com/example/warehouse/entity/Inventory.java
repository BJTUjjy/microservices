package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@Column(name = "item_id")
	private String itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "quantity")
	private int quantity;

}


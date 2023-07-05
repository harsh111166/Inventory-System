package com.inventory.dto;

public class InventoryRequestDto {

	private Integer Id;
	private String InventoryName;
	private Integer quantity;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getInventoryName() {
		return InventoryName;
	}

	public void setInventoryName(String inventoryName) {
		InventoryName = inventoryName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

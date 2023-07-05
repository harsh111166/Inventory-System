package com.inventory.service;

import java.util.List;

import com.inventory.dto.InventoryDto;
import com.inventory.dto.InventoryRequestDto;

public interface InventoryService {

	InventoryDto addStock(InventoryRequestDto inventoryRequestDto);

	InventoryDto getStock(int id);

	InventoryDto updateStock(InventoryRequestDto inventoryRequestDto);

	String deleteStock(int id);

	List<InventoryDto> getAllStock();

}

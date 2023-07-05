package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.InventoryDto;
import com.inventory.dto.InventoryRequestDto;
import com.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/saveInventory")
	public @ResponseBody InventoryDto saveInventory(@RequestBody InventoryRequestDto inventoryRequestDto) {
		return inventoryService.addStock(inventoryRequestDto);

	}

	@GetMapping("/get/{id}")
	public @ResponseBody InventoryDto getInventory(@PathVariable("id") int id) {
		return inventoryService.getStock(id);

	}

	@GetMapping("/all")
	public @ResponseBody List<InventoryDto> getAllUniversity() {
		return inventoryService.getAllStock();

	}

	@PutMapping("/update")
	public @ResponseBody InventoryDto updateUniversity(@RequestBody InventoryRequestDto inventoryRequestDto) {
		return inventoryService.updateStock(inventoryRequestDto);

	}

	@DeleteMapping("delete/{id}")
	public String deleteInventory(@PathVariable("id") int id) {
		return inventoryService.deleteStock(id);
	}

}

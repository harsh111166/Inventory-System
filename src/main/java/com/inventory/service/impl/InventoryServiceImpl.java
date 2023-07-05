package com.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.InventoryDto;
import com.inventory.dto.InventoryRequestDto;
import com.inventory.entity.Inventory;
import com.inventory.repository.InventoryRepo;
import com.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;

	@Override
	public InventoryDto addStock(InventoryRequestDto inventoryRequestDto) {
		InventoryDto inventoryDto = new InventoryDto();
		Inventory inventory = new Inventory();
		BeanUtils.copyProperties(inventoryRequestDto, inventory);
		inventoryRepo.save(inventory);
		BeanUtils.copyProperties(inventory, inventoryDto);
		return inventoryDto;
	}

	@Override
	public InventoryDto getStock(int id) {
		InventoryDto inventoryDto = new InventoryDto();
		Optional<Inventory> inventoryOptional = inventoryRepo.findById(id);
		if (inventoryOptional.isPresent()) {
			Inventory inventory = inventoryOptional.get();
			BeanUtils.copyProperties(inventory, inventoryDto);
		}
		return inventoryDto;
	}

	@Override
	public InventoryDto updateStock(InventoryRequestDto inventoryRequestDto) {
		InventoryDto inventoryDto = new InventoryDto();
		Optional<Inventory> inventoryOptional = inventoryRepo.findById(inventoryRequestDto.getId());
		if (inventoryOptional.isPresent()) {
			Inventory inventory = new Inventory();
			BeanUtils.copyProperties(inventoryRequestDto, inventory);
			inventoryRepo.save(inventory);
			BeanUtils.copyProperties(inventory, inventoryDto);
			return inventoryDto;
		}
		return null;
	}

	@Override
	public String deleteStock(int id) {
		inventoryRepo.deleteById(id);
		return "Success";
	}

	@Override
	public List<InventoryDto> getAllStock() {
		List<InventoryDto> dtoList = new ArrayList<InventoryDto>();
		List<Inventory> inventoryList = inventoryRepo.findAll();
		for (Inventory inventory : inventoryList) {
			InventoryDto inventoryDto = new InventoryDto();
			BeanUtils.copyProperties(inventory, inventoryDto);
			dtoList.add(inventoryDto);
		}
		return dtoList;
	}

}

package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

}

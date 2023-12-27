package com.stephanward.eqp.inventory.repositories;

import com.stephanward.eqp.inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {
}

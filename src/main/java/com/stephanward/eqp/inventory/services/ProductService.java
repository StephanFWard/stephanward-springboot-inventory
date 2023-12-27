package com.stephanward.eqp.inventory.services;

import com.stephanward.eqp.inventory.entities.Product;
import com.stephanward.eqp.inventory.entities.RecalledProduct;
import com.stephanward.eqp.inventory.helpers.ProductFilter;
import com.stephanward.eqp.inventory.repositories.InventoryRepository;
import com.stephanward.eqp.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final RecalledProductRepository recalledProductRepository;

    @Transactional
    public Product save(Product product) {
        return inventoryRepository.save(product);
    }

    public Collection<Product> getAllProduct() {
        ProductFilter filter = new ProductFilter(null);

        return filter.removeRecalledFrom(inventoryRepository.findAll());
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}

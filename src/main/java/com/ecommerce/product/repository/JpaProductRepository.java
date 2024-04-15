package com.ecommerce.product.repository;

import com.ecommerce.product.mapper.ProductDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProductRepository extends JpaRepository<ProductDataMapper, Integer> {

    Optional<ProductDataMapper> findByName(String name);
}

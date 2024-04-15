package com.ecommerce.product.repository;

import com.ecommerce.product.mapper.StatusDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStatusRepository extends JpaRepository<StatusDataMapper, Integer> {
}

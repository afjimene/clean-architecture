package com.ecommerce.product.factory;

import com.ecommerce.product.model.Product;

import java.math.BigDecimal;

public interface ProductFactory {

    Product create(String name, Integer status, Long stock, String description, BigDecimal price);
    Product update(Integer productId, String name, Integer status, Long stock, String description, BigDecimal price);
}

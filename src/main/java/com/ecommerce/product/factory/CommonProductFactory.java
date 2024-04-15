package com.ecommerce.product.factory;

import com.ecommerce.product.model.CommonProduct;
import com.ecommerce.product.model.Product;

import java.math.BigDecimal;

public class CommonProductFactory implements ProductFactory {
    @Override
    public Product create(String name, Integer status, Long stock, String description, BigDecimal price) {
        return new CommonProduct(name, status, stock, description, price);
    }

    @Override
    public Product update(Integer productId, String name, Integer status, Long stock, String description, BigDecimal price) {
        return new CommonProduct(productId, name, status, stock, description, price);
    }

    public Product getById(Integer productId) {
        return new CommonProduct(productId);
    }
}

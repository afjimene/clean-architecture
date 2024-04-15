package com.ecommerce.product.model;

import java.math.BigDecimal;

public class CommonProduct implements Product {

    Integer productId;
    String name;
    Integer statusId;
    Long stock;
    String description;
    BigDecimal price;

    public CommonProduct(Integer productId) {
        this.productId = productId;
    }

    public CommonProduct(Integer productId, String name, Integer statusId, Long stock, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.statusId = statusId;
        this.stock = stock;
        this.description = description;
        this.price = price;
    }

    public CommonProduct(String name, Integer statusId, Long stock, String description, BigDecimal price) {
        this.name = name;
        this.statusId = statusId;
        this.stock = stock;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getStatusId() {
        return statusId;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal getFinalPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Long getStock() {
        return stock;
    }
}

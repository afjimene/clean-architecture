package com.ecommerce.product.model;

import java.math.BigDecimal;

public class ProductUpdateModel {

    Integer productId;
    String name;
    Integer statusId;
    Long stock;
    String description;
    BigDecimal price;

    public ProductUpdateModel(Integer productId, String name, Integer statusId, Long stock, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.statusId = statusId;
        this.stock = stock;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Long getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

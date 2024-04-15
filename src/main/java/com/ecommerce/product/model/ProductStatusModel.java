package com.ecommerce.product.model;

import java.math.BigDecimal;

public class ProductStatusModel {

    Integer productId;
    String name;
    String status;
    Long stock;
    String description;
    BigDecimal price;
    Integer discount;
    BigDecimal finalPrice;

    public ProductStatusModel(Integer productId,
                              String name,
                              String status,
                              Long stock,
                              String description,
                              BigDecimal price,
                              Integer discount,
                              BigDecimal finalPrice) {
        this.productId = productId;
        this.name = name;
        this.status = status;
        this.stock = stock;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
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

    public Integer getDiscount() {
        return discount;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }
}

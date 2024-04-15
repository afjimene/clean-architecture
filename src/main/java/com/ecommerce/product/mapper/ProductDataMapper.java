package com.ecommerce.product.mapper;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class ProductDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;
    @NotBlank(message = "Name is required")
    String name;
    Integer statusId;
    Long stock;
    String description;
    @PositiveOrZero(message = "Price must be zero or greater")
    BigDecimal price;

    public ProductDataMapper() {}

    public ProductDataMapper(Integer productId, String name, Integer statusId, Long stock, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.statusId = statusId;
        this.stock = stock;
        this.description = description;
        this.price = price;
    }

    public ProductDataMapper(String name, Integer statusId, Long stock, String description, BigDecimal price) {
        this.name = name;
        this.statusId = statusId;
        this.stock = stock;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

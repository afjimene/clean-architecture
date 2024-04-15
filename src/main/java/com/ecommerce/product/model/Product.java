package com.ecommerce.product.model;

import java.math.BigDecimal;

public interface Product {
    Integer getProductId();
    String getName();
    Integer getStatusId();
    Long getStock();
    BigDecimal getPrice();
    BigDecimal getFinalPrice();
    String getDescription();
}

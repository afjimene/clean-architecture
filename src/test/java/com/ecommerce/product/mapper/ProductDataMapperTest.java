package com.ecommerce.product.mapper;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductDataMapperTest {

    @Autowired
    private Validator validator;

    @Test
    void validProduct() {
        // Arrange
        ProductDataMapper product = new ProductDataMapper("TV", 1, 100L, "Home TV", BigDecimal.valueOf(500.0));
        // Act
        var violations = validator.validate(product);
        // Assert
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidProduct() {
        // Arrange
        ProductDataMapper product = new ProductDataMapper("  ", 1, 50L, "No description", BigDecimal.valueOf(-10.0));
        // Act
        var violations = validator.validate(product);
        // Assert
        assertEquals(2, violations.size());
        violations.forEach(System.out::println);
    }


}

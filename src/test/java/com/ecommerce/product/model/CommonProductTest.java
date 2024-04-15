package com.ecommerce.product.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonProductTest {

    @Test
    void givenProductSimpleValidateFields() {
        //Arrange
        Product product = new CommonProduct(
                "tablet",
                1,
                100L,
                "This is a Tablet",
                new BigDecimal("1000.00"));
        //Act
        var price = product.getPrice().toString();

        //Assert
        assertEquals("1000.00", price);
    }
}

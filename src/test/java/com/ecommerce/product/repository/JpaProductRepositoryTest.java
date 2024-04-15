package com.ecommerce.product.repository;

import com.ecommerce.product.mapper.ProductDataMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JpaProductRepositoryTest {

    @Autowired
    private JpaProductRepository repository;

    @Test
    void countProducts() {
        assertEquals(3, repository.count());
    }

    @Test
    void findById() {
        assertTrue(repository.findById(1).isPresent());
    }

    @Test
    void findByName() {
        assertTrue(repository.findByName("tablet").isPresent());
    }

    @Test
    void findAll() {
        List<ProductDataMapper> products = repository.findAll();
        assertEquals(3, products.size());
        products.forEach(System.out::println);
    }

    @Test
    void insertProduct() {
        ProductDataMapper tv = new ProductDataMapper("TV", 1, 100L, "A TV", BigDecimal.valueOf(300.0));
        repository.save(tv);
        assertAll(
                () -> assertNotNull(tv.getProductId()),
                () -> assertEquals(4, repository.count())
        );
    }
}

package com.ecommerce.product.controller;

import com.ecommerce.product.api.handler.ProductApi;
import com.ecommerce.product.api.model.Product;
import com.ecommerce.product.api.model.ProductStatus;
import com.ecommerce.product.interactor.ProductInputBoundary;
import com.ecommerce.product.interactor.ProductOutputBoundary;
import com.ecommerce.product.model.ProductRequestModel;
import com.ecommerce.product.model.ProductUpdateModel;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProductRestController implements ProductApi {

    final ProductInputBoundary productInput;
    final ProductOutputBoundary productOutput;

    public ProductRestController(ProductInputBoundary productInput, ProductOutputBoundary productOutput) {
        this.productInput = productInput;
        this.productOutput = productOutput;
    }

    @Override
    @Timed(value = "add.product", description = "Time taken to create a product")
    public ResponseEntity<Product> addProduct(Product body) {
        var productRequest = new ProductRequestModel(
                body.getName(),
                body.getStatusId(),
                body.getStock(),
                body.getDescription(),
                BigDecimal.valueOf(body.getPrice())
        );
        var productResponse = productInput.create(productRequest);
        var product = new Product();
        product.setId(productResponse.getProductId());
        product.setName(productResponse.getName());
        product.setStatusId(productResponse.getStatusId());
        product.setStock(productResponse.getStock());
        product.setDescription(productResponse.getDescription());
        product.setPrice(productResponse.getPrice().doubleValue());
        return ResponseEntity.ok(product);
    }

    @Override
    @Timed(value = "get.product", description = "Time taken to get a product")
    public ResponseEntity<ProductStatus> getProductById(Integer productId) {
        var productResponse = productOutput.getById(productId);
        var product = new ProductStatus();
        product.setId(productResponse.getProductId());
        product.setName(productResponse.getName());
        product.setStatus(productResponse.getStatus());
        product.setStock(productResponse.getStock());
        product.setDescription(productResponse.getDescription());
        product.setPrice(productResponse.getPrice().doubleValue());
        product.setDiscount(productResponse.getDiscount().longValue());
        product.setFinalPrice(productResponse.getFinalPrice().doubleValue());
        return ResponseEntity.ok(product);
    }

    @Override
    @Timed(value = "put.product", description = "Time taken to update a product")
    public ResponseEntity<Product> updateProduct(Product body) {
        var productUpdate = new ProductUpdateModel(
                body.getId(),
                body.getName(),
                body.getStatusId(),
                body.getStock(),
                body.getDescription(),
                BigDecimal.valueOf(body.getPrice())
        );
        var productResponse = productInput.update(productUpdate);
        var product = new Product();
        product.setId(productResponse.getProductId());
        product.setName(productResponse.getName());
        product.setStatusId(productResponse.getStatusId());
        product.setStock(productResponse.getStock());
        product.setDescription(productResponse.getDescription());
        product.setPrice(productResponse.getPrice().doubleValue());
        return ResponseEntity.ok(product);
    }
}

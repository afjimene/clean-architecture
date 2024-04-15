package com.ecommerce.product.repository;

import com.ecommerce.product.gateway.ProductDsGateway;
import com.ecommerce.product.mapper.ProductDataMapper;
import com.ecommerce.product.model.ProductDsRequestModel;
import com.ecommerce.product.model.ProductDsResponseModel;

public class JpaProduct implements ProductDsGateway {

    final JpaProductRepository repository;

    public JpaProduct(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(String name) {
        return (repository.findByName(name).isPresent());
    }

    @Override
    public Integer save(ProductDsRequestModel requestModel) {
        ProductDataMapper productDataMapper = new ProductDataMapper(requestModel.getName(),
                requestModel.getStatusId(),
                requestModel.getStock(),
                requestModel.getDescription(),
                requestModel.getPrice());
        var savedProduct = this.repository.save(productDataMapper);
        return savedProduct.getProductId();
    }

    @Override
    public void update(ProductDsRequestModel requestModel) {
        ProductDataMapper productDataMapper = new ProductDataMapper(requestModel.getProductId(),
                requestModel.getName(),
                requestModel.getStatusId(),
                requestModel.getStock(),
                requestModel.getDescription(),
                requestModel.getPrice());
        this.repository.save(productDataMapper);
    }

    @Override
    public ProductDsResponseModel getById(Integer productId) {
        ProductDataMapper productDataMapper = this.repository.getReferenceById(productId);
        return new ProductDsResponseModel(productDataMapper.getProductId(),
                productDataMapper.getName(),
                productDataMapper.getStatusId(),
                productDataMapper.getStock(),
                productDataMapper.getDescription(),
                productDataMapper.getPrice());
    }
}

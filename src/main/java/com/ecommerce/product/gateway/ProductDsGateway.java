package com.ecommerce.product.gateway;

import com.ecommerce.product.model.ProductDsRequestModel;
import com.ecommerce.product.model.ProductDsResponseModel;

public interface ProductDsGateway {
    boolean existsByName(String name);
    Integer save(ProductDsRequestModel requestModel);
    void update(ProductDsRequestModel updateModel);
    ProductDsResponseModel getById(Integer productId);
}

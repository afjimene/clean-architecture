package com.ecommerce.product.presenter;

import com.ecommerce.product.model.ProductResponseModel;
import com.ecommerce.product.model.ProductStatusModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductResponseFormatter implements ProductPresenter {
    @Override
    public ProductResponseModel prepareSuccessView(ProductResponseModel product) {
        return product;
    }

    @Override
    public ProductStatusModel prepareSuccessView(ProductStatusModel productStatusModel) {
        return productStatusModel;
    }

    @Override
    public ProductResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}

package com.ecommerce.product.presenter;

import com.ecommerce.product.model.ProductResponseModel;
import com.ecommerce.product.model.ProductStatusModel;

public interface ProductPresenter {

    ProductResponseModel prepareSuccessView(ProductResponseModel product);
    ProductStatusModel prepareSuccessView(ProductStatusModel productStatusModel);
    ProductResponseModel prepareFailView(String error);
}

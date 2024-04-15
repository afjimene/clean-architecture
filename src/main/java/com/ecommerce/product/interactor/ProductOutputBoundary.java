package com.ecommerce.product.interactor;

import com.ecommerce.product.model.ProductStatusModel;

public interface ProductOutputBoundary {
    ProductStatusModel getById(Integer productId);
}

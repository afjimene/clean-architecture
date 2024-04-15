package com.ecommerce.product.interactor;

import com.ecommerce.product.model.ProductRequestModel;
import com.ecommerce.product.model.ProductResponseModel;
import com.ecommerce.product.model.ProductUpdateModel;

public interface ProductInputBoundary {

    ProductResponseModel create(ProductRequestModel requestModel);
    ProductResponseModel update(ProductUpdateModel updateModel);

}

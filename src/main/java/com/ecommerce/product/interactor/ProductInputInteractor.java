package com.ecommerce.product.interactor;

import com.ecommerce.product.factory.ProductFactory;
import com.ecommerce.product.gateway.ProductDsGateway;
import com.ecommerce.product.model.*;
import com.ecommerce.product.presenter.ProductPresenter;

public class ProductInputInteractor implements ProductInputBoundary {

    final ProductDsGateway productDsGateway;
    final ProductPresenter userPresenter;
    final ProductFactory productFactory;

    public ProductInputInteractor(ProductDsGateway productDsGateway, ProductPresenter userPresenter, ProductFactory productFactory) {
        this.productDsGateway = productDsGateway;
        this.userPresenter = userPresenter;
        this.productFactory = productFactory;
    }

    @Override
    public ProductResponseModel create(ProductRequestModel requestModel) {
        if (productDsGateway.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("Product already exists.");
        }
        Product product = productFactory.create(requestModel.getName(),
                requestModel.getStatusId(),
                requestModel.getStock(),
                requestModel.getDescription(),
                requestModel.getPrice());
        ProductDsRequestModel productDsModel = new ProductDsRequestModel(product.getName(),
                product.getStatusId(),
                product.getStock(),
                product.getDescription(),
                product.getPrice());

        Integer productId = productDsGateway.save(productDsModel);

        ProductResponseModel productModel = new ProductResponseModel(productId,
                product.getName(),
                product.getStatusId(),
                product.getStock(),
                product.getDescription(),
                product.getPrice());
        return userPresenter.prepareSuccessView(productModel);
    }

    @Override
    public ProductResponseModel update(ProductUpdateModel updateModel) {
        Product product = productFactory.update(updateModel.getProductId(),
                updateModel.getName(),
                updateModel.getStatusId(),
                updateModel.getStock(),
                updateModel.getDescription(),
                updateModel.getPrice());
        ProductDsRequestModel productDsModel = new ProductDsRequestModel(product.getProductId(),
                product.getName(),
                product.getStatusId(),
                product.getStock(),
                product.getDescription(),
                product.getPrice());
        productDsGateway.update(productDsModel);
        ProductResponseModel productModel = new ProductResponseModel(product.getProductId(),
                product.getName(),
                product.getStatusId(),
                product.getStock(),
                product.getDescription(),
                product.getPrice());
        return userPresenter.prepareSuccessView(productModel);
    }

}

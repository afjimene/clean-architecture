package com.ecommerce.product.interactor;

import com.ecommerce.product.gateway.ProductDsGateway;
import com.ecommerce.product.gateway.StatusDsGateway;
import com.ecommerce.product.model.Discount;
import com.ecommerce.product.model.ProductDsResponseModel;
import com.ecommerce.product.model.ProductStatusModel;
import com.ecommerce.product.presenter.ProductPresenter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductOutputInteractor implements ProductOutputBoundary {

    final RestTemplate template;
    final ProductDsGateway productDsGateway;
    final StatusDsGateway statusDsGateway;
    final ProductPresenter userPresenter;

    public ProductOutputInteractor(RestTemplateBuilder templateBuilder, ProductDsGateway productDsGateway, StatusDsGateway statusDsGateway, ProductPresenter userPresenter) {
        this.template = templateBuilder.rootUri("https://661aa70f65444945d04e3afa.mockapi.io").build();
        this.productDsGateway = productDsGateway;
        this.statusDsGateway = statusDsGateway;
        this.userPresenter = userPresenter;
    }

    @Override
    public ProductStatusModel getById(Integer productId) {
        var statusList = statusDsGateway.getAllStatus();
        ProductDsResponseModel productResponse = productDsGateway.getById(productId);
        Map<String, Integer> mapDiscounts = new HashMap<>();
        var discounts = this.template.getForObject("/discount/v1/discount", Discount[].class);
        Arrays.stream(discounts)
                .forEach(dis -> mapDiscounts.put(dis.getId(), dis.getDiscount()));
        var price = productResponse.getPrice();
        var discount = mapDiscounts.getOrDefault(productResponse.getProductId().toString(), 0);
        var finalPrice = price.multiply(BigDecimal.valueOf(100 - discount)).divide(BigDecimal.valueOf(100.0), RoundingMode.CEILING);
        ProductStatusModel productModel = new ProductStatusModel(productResponse.getProductId(),
                productResponse.getName(),
                statusList.get(productResponse.getStatusId()),
                productResponse.getStock(),
                productResponse.getDescription(),
                price,
                discount,
                finalPrice);
        return userPresenter.prepareSuccessView(productModel);
    }
}

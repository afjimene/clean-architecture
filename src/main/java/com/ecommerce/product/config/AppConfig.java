package com.ecommerce.product.config;

import com.ecommerce.product.factory.CommonProductFactory;
import com.ecommerce.product.factory.ProductFactory;
import com.ecommerce.product.gateway.ProductDsGateway;
import com.ecommerce.product.gateway.StatusDsGateway;
import com.ecommerce.product.interactor.ProductInputBoundary;
import com.ecommerce.product.interactor.ProductInputInteractor;
import com.ecommerce.product.interactor.ProductOutputBoundary;
import com.ecommerce.product.interactor.ProductOutputInteractor;
import com.ecommerce.product.presenter.ProductPresenter;
import com.ecommerce.product.presenter.ProductResponseFormatter;
import com.ecommerce.product.repository.JpaProduct;
import com.ecommerce.product.repository.JpaProductRepository;
import com.ecommerce.product.repository.JpaStatus;
import com.ecommerce.product.repository.JpaStatusRepository;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@Configuration
@EnableCaching
@EnableScheduling
public class AppConfig {

    private final JpaProductRepository productRepository;
    private final JpaStatusRepository statusRepository;

    @Autowired
    public AppConfig(JpaProductRepository productRepository, JpaStatusRepository statusRepository) {
        this.productRepository = productRepository;
        this.statusRepository = statusRepository;
    }

    @Bean
    public ProductDsGateway getGateway() {
        return new JpaProduct(productRepository);
    }

    @Bean
    public StatusDsGateway getStatusGateway() {
        return new JpaStatus(statusRepository);
    }

    @Bean
    public ProductPresenter getPresenter() {
        return new ProductResponseFormatter();
    }

    @Bean
    public ProductFactory getFactory() {
        return new CommonProductFactory();
    }

    @Bean
    public ProductInputBoundary getInputBoundary() {
        return new ProductInputInteractor(getGateway(), getPresenter(), getFactory());
    }

    @Bean
    public ProductOutputBoundary getOutputBoundary() {
        return new ProductOutputInteractor(new RestTemplateBuilder(), getGateway(), getStatusGateway(), getPresenter());
    }

    @Bean
    public CacheManager cacheManager() {
        var cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(new ConcurrentMapCache("status")));
        return cacheManager;
    }

    @Bean
    TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}

package com.ecommerce.product.repository;

import com.ecommerce.product.gateway.StatusDsGateway;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

public class JpaStatus implements StatusDsGateway {

    final JpaStatusRepository repository;

    public JpaStatus(JpaStatusRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("status")
    public Map<Integer, String> getAllStatus() {
        final Map<Integer, String> values = new HashMap<>();
        repository.findAll()
                .forEach(status -> values.put(status.getStatus(), status.getStatusName()));
        return values;
    }

}

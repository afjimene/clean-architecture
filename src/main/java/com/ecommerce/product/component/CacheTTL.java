package com.ecommerce.product.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheTTL {

    Logger logger = LoggerFactory.getLogger(CacheTTL.class);

    @CacheEvict(value = "status", allEntries = true)
    @Scheduled(fixedRateString = "${caching.spring.statusTTL}")
    public void emptyCache() {
        logger.info("emptying status cache");
    }
}

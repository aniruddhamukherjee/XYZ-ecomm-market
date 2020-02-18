package com.aniruddha.XYZecommmarket.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductCache {

    @Autowired
    CacheManager cacheManager;

    /**
     * Refresh particular cache based on cachename and key
     * @param cacheName
     * @param cacheKey
     */
    public void evictSingleCacheValue(String cacheName, String cacheKey) {
        cacheManager.getCache(cacheName).evict(cacheKey);
    }

    /**
     * Refresh all cache
     */
    public void evictAllCacheValues(String cacheName) {
        cacheManager.getCache(cacheName).clear();
    }

    /**
     * Refresh cache after every 2 hrs, with initial start delay of 10 mins
     */
    @Scheduled(fixedRate=2*60*60*1000, initialDelay=10*60*1000)
    public void refreshCacheAtIntervals(){
        evictAllCacheValues("products");
    }
}

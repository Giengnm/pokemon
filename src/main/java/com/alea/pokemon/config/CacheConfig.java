package com.alea.pokemon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableCaching
@EnableScheduling
@Slf4j
@Configuration
public class CacheConfig {

  private CacheManager cacheManager;

  public CacheConfig(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }

  public void refreshAllCaches() {
    cacheManager.getCacheNames()
        .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
  }

  @Scheduled(fixedRateString = "${cache.timeout}", initialDelay = 1000)
  public void refreshAllCachesAtIntervals() {
    log.info("Clear cache!!");
    refreshAllCaches();
  }

}

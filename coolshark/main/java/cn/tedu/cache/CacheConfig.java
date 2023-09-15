package cn.tedu.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@EnableCaching //开启缓存
@Configuration
public class CacheConfig {
    /*
     * Caffeine配置说明：
     *   initialCapacity=[integer]: 初始的缓存空间大小
     *   maximumSize=[long]: 缓存的最大条数
     *   expireAfterWrite=[duration]: 最后一次写入后经过固定时间过期
     *   refreshAfterWrite=[duration]: 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> list = new ArrayList<>();
        //循环添加枚举类中的自定义缓存
        for (CacheEnum cacheEnum : CacheEnum.values()) {
            list.add(new CaffeineCache(cacheEnum.getName(),
                    Caffeine.newBuilder()
                            .initialCapacity(50)
                            .maximumSize(1000)
                            .expireAfterWrite(cacheEnum.getExpires(), TimeUnit.SECONDS)
                            .build()));
        }
        cacheManager.setCaches(list);
        return cacheManager;
    }
}

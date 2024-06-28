package org.redisCache.config;

import org.redisCache.util.constants.CacheNames;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {
    @Value("${cache.config.entryTtl:60}")
    private int entryTtl;

    @Value("${cache.config.userInfo.entryTtl:30}")
    private int userInfoEntryTtl;

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(entryTtl))
                .disableCachingNullValues()
                .serializeValuesWith( RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> {
            RedisCacheConfiguration countryNamesConf = RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofMinutes(userInfoEntryTtl));
            builder.withCacheConfiguration(CacheNames.USER_INFO, countryNamesConf);
        };
    }


}

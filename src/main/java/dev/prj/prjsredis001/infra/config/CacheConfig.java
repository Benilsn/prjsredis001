package dev.prj.prjsredis001.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

  @Value("${data.redis.ttl-in-minutes}")
  public long ttlInMinutes;

  @Bean
  public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {

    RedisCacheConfiguration config =
      RedisCacheConfiguration
        .defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(ttlInMinutes))
        .disableCachingNullValues()
        .serializeValuesWith(
          RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));

    return
      RedisCacheManager
        .builder(connectionFactory)
        .cacheDefaults(config)
        .build();
  }

}
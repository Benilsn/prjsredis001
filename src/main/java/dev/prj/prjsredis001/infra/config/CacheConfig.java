package dev.prj.prjsredis001.infra.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {

    RedisCacheConfiguration config =
      RedisCacheConfiguration
        .defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(10))
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
package com.hasindu.redissample.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * @author hasindu_d
 */
@EnableTransactionManagement
@EnableRedisRepositories
public class RedisConfig {


    @Value("${redis.cluster.nodes}")
    private List<String> clusterNodes;


    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(
                new RedisClusterConfiguration(clusterNodes));
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // Use Jackson2JsonRedisSerializer to serialize and deserialize the value of redis (the default use JDK serialization)
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        // specify the domain to be serialized, field, get and set, and the scope of the modifier, ANY has both private and public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // specify the type of serialized input, the class must be non-final modified, final modified class, such as String, Integer, etc. will run out of exception
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // value is serialized with json
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // Use StringRedisSerializer to serialize and deserialize the key value of redis
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // Set the hash key and value serialization mode
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);

        //Enabling @Transactional annotation support to handle Redis transactions
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    CacheManager cacheManager() {
        final RedisCacheManager redisCacheManager = RedisCacheManager.create(redisConnectionFactory());
        return redisCacheManager;
    }

}

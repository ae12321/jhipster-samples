package com.mycompany.myapp.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/api")
public class StudyRedis {

    @Value("${cache.host}")
    private String cacheHost;

    @Value("${cache.port}")
    private int cachePort;

    @Value("${cache.key}")
    private String cacheKey;

    @Value("${cache.ssl}")
    private boolean cacheSsl;

    @GetMapping("/study/redis/add/{key}/{value}")
    public String add(@PathVariable String key, @PathVariable String value) {
        Jedis jedis = new Jedis(cacheHost, cachePort, DefaultJedisClientConfig.builder().password(cacheKey).ssl(cacheSsl).build());
        jedis.set(key, value);
        jedis.close();
        return String.format("add done. %s: %s", key, value);
    }

    @GetMapping("/study/redis/get/{key}")
    public String get(@PathVariable String key) {
        Jedis jedis = new Jedis(cacheHost, cachePort, DefaultJedisClientConfig.builder().password(cacheKey).ssl(cacheSsl).build());
        String value = jedis.get(key);
        jedis.close();
        return String.format("get done. %s: %s", key, value);
    }
}

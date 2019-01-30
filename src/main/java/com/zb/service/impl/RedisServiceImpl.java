package com.zb.service.impl;

import com.zb.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2019/1/27.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 设置key，value
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置过期时间的key
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置过期时间的key (毫秒)
     * @param key
     * @param value
     * @param timeout
     */
    @Override
    public void set(String key, String value, Long timeout) {
        set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

}

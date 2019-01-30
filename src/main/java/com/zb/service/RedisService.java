package com.zb.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzheng on 2019/1/30.
 */
public interface RedisService {

    /**
     * 设置key，value
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 设置过期时间的key
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    void set(String key, String value, Long timeout, TimeUnit timeUnit);

    /**
     * 设置过期时间的key (毫秒)
     *
     * @param key
     * @param value
     * @param timeout
     */
    void set(String key, String value, Long timeout);

    /**
     * @param key
     * @return
     */
    String get(String key);
}

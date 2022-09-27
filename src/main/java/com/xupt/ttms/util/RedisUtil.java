package com.xupt.ttms.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

public class RedisUtil {
    /**
     * 删除redis中指定前缀的key
     * @param param
     * @param redisTemplate
     * @return
     */
    public static long deleteCaChe(String param, RedisTemplate redisTemplate){
        Set keys = redisTemplate.keys(param);
        return redisTemplate.delete(keys);
    }
}

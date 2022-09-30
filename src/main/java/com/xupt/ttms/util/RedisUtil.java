package com.xupt.ttms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

public class RedisUtil {
    @Autowired
    private static RedisTemplate redisTemplate;
    /**
     * 删除redis中指定前缀的key
     * @param param
     * @return
     */
    public static long deleteCaChe(String param){
        Set keys = redisTemplate.keys(param);
        return redisTemplate.delete(keys);
    }
}

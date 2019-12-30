package com.caglartelef.redis.service;

import com.caglartelef.redis.utility.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisUtil<String> redisUtil;

    public void setUserInfo(String cacheKey, String value) {
        redisUtil.putValue(cacheKey, value);
    }

    public String getUserInfo(String cacheKey) {
        return redisUtil.getValue(cacheKey);
    }
}

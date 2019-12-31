package com.caglartelef.redis.service;

import com.caglartelef.redis.exception.exceptions.RedisException;
import com.caglartelef.redis.utility.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RedisService {

    @Autowired
    private RedisUtil<String> redisUtil;

    /**
     * This method goes to redis and add user information
     */
    public void setUserInfo(String cacheKey, String value) {
        try {
            redisUtil.putValue(cacheKey, value);
        } catch (Exception ex) {
            /**
             * When the database throws an error message, we catch it.
             * We throw a special error message by turning it into a meaningful message.
             * */
            throw new RedisException("Redis exception message: " + ex.getMessage());
        }
    }

    /**
     * This method goes to redis and get user information
     */
    public String getUserInfo(String cacheKey) {
        try {
            return redisUtil.getValue(cacheKey);
        } catch (Exception ex) {
            /**
             * When the database throws an error message, we catch it.
             * We throw a special error message by turning it into a meaningful message.
             * */
            throw new RedisException("Redis exception message: " + ex.getMessage());
        }
    }
}

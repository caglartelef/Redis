package com.caglartelef.redis.exception.exceptions;

public class RedisException extends RuntimeException {
    public RedisException(String message) {
        super(message);
        System.out.println(message);
    }
}

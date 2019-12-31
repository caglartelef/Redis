package com.caglartelef.redis.exception.exceptions;

/***
 *  Custom Exception
 */
public final class RedisException extends RuntimeException {
    public RedisException(String message) {
        super(message);
        System.out.println(message);
    }
}

package com.caglartelef.redis.exception.handler;

import com.caglartelef.redis.exception.exceptions.RedisException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Global Exception Handler
 */
@RestControllerAdvice
public final class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /**
     * Response Status
     * */
    @ExceptionHandler(RedisException.class)
    /**
     * Custom Exception class
     * */
    public String handlingRedisException(RedisException redisException) {
        return redisException.getMessage();
    }
}

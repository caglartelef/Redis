package com.caglartelef.redis.dto;

import lombok.Data;

/**
 * Data object
 * */
@Data
public final class UserInfo {
    private String Id;
    private String email;
    private String password;
}

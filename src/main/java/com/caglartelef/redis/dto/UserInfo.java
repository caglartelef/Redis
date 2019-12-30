package com.caglartelef.redis.dto;

import lombok.Data;

@Data
public class UserInfo {
    private int Id;
    private String email;
    private String password;
}

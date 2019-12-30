package com.caglartelef.redis.controller;

import com.caglartelef.redis.dto.UserInfo;
import com.caglartelef.redis.service.RedisService;
import com.caglartelef.redis.utility.JsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/set")
    public void setRedis() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setEmail("info@caglartelef.com");
        userInfo.setPassword("12345");
        redisService.setUserInfo(userInfo.getEmail(), JsonConvertUtil.convertFromClassToJson(userInfo));
    }

    @GetMapping("/get")
    public UserInfo getService() {
        String value = redisService.getUserInfo("info@caglartelef.com");
        return JsonConvertUtil.convertFromJsonToClass(value, UserInfo.class);
    }

}

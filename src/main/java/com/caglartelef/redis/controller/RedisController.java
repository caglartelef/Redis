package com.caglartelef.redis.controller;

import com.caglartelef.redis.dto.UserInfo;
import com.caglartelef.redis.service.RedisService;
import com.caglartelef.redis.utility.JsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public final class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/set")
    public void setRedis() {
        // we want to save class type on redis
        UserInfo userInfo = new UserInfo();
        // Using id we have set it as cache key.
        userInfo.setId("1");
        userInfo.setEmail("info@caglartelef.com");
        userInfo.setPassword("12345");
        // From UserInfo class to json object
        String json = JsonConvertUtil.convertFromClassToJson(userInfo);
        // Data is saving on redis service
        redisService.setUserInfo(userInfo.getEmail(), json);
    }

    @GetMapping("/get")
    public UserInfo getService() {
        // The data is retrieved from redis using the key.
        String value = redisService.getUserInfo("1");
        // From json object class to UserInfo class
        return JsonConvertUtil.convertFromJsonToClass(value, UserInfo.class);
    }

}

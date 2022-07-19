package com.guocz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @author guocz
 * @date 2022/7/19 14:46
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("get")
    @ResponseBody
    public String get(@PathParam("key") String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }


    @ResponseBody
    @GetMapping("set")
    public String set(@PathParam("key") String key, @PathParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }
}

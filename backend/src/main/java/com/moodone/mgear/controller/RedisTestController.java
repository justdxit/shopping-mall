package com.moodone.mgear.controller;

import com.moodone.mgear.dto.TestReq;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisTestController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping(value = "/setRedisKeyValue", method = RequestMethod.POST)
    public ResponseEntity<?> setRedisKeyValue(HttpServletRequest request) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set("name", "이병무");
        vop.set("age", "35");
        vop.set("country", "korea");
        vop.set("gender", "male");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getRedisKeyValue", method = RequestMethod.GET)
    public ResponseEntity<?> getRedisKeyValue(TestReq req, HttpServletRequest request) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get(req.getKey());
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}

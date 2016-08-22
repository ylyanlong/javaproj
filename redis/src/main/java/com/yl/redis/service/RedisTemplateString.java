package com.yl.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by Administrator on 2016/6/7.
 */
public class RedisTemplateString {
    private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateString.class);

    private StringRedisTemplate stringRedisTemplate;

    public RedisTemplateString(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void writeAndRead(){
        LOG.info("writeAndRead");
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("keyt", "valuet");
        String value = valueOperations.get("keyt");
        LOG.info("writeAndRead value:{}", value);
    }
}

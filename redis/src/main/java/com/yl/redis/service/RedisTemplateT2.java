package com.yl.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/7.
 */
@Repository
public class RedisTemplateT2 {
    private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateT2.class);

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;  // 两种方式是等效的，可以二选一

    public void listAdd(){
        LOG.info("RedisTemplateT2 listAdd");
        String key = "spring";
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(serializer);
        listOperations.leftPush(key, "aaa");
        listOperations.leftPush(key, "bbb");

        redisTemplate.opsForHash();
    }

    public void addList(){
        listOps.leftPush("jlist1", "a1");
        listOps.leftPush("jlist1", "b1");
        listOps.leftPush("jlist1", "c1");
    }

    public void removeListKey(){
        redisTemplate.delete("jlist1");
    }

    /*public void stringRedisTemplateTest(){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
    }*/

}

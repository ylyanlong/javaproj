package com.yl.redis.service;

import com.yl.redis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/6/7.
 */
@Repository
public class RedisTemplateT1 {
    private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateT1.class);
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    public void save(User user){
        LOG.info("save");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(String.valueOf(user.getUid()), user);
    }

    public User read(int uid){
        LOG.info("read");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(String.valueOf(uid));
    }

    public void delete(int uid){
        LOG.info("delete");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        RedisOperations<String, User> redisOperations = valueOperations.getOperations();
        redisOperations.delete(String.valueOf(uid));
    }

}

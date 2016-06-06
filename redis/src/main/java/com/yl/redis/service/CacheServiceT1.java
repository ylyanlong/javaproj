package com.yl.redis.service;

import com.yl.redis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/6/6.
 */
@Service
public class CacheServiceT1 {
    private static final Logger LOG = LoggerFactory.getLogger(CacheServiceT1.class);

    @Cacheable("getInfoById")
    public int getInfoById(int uid){
        LOG.info("getInfoById executed!!!");

        return uid + 100;
    }

    @CachePut("getInfoById")
    public int saveInfoById(int uid){
        LOG.info("saveInfoById executed!!!");

        return uid + 100;
    }

    @CachePut(value = "getInfoById", key = "#result.uid")
    public User setUser(User user){
        LOG.info("setUser executed!!!");
        user = new User();
        user.setUid(115);
        user.setName("tom");

        return user;
    }

    @Cacheable(value = "getInfoById", unless = "#uid<50")
    public int getInfoByIdWithUnless(int uid){
        LOG.info("getInfoByIdWithUnless executed!!!");

        return uid + 100;
    }

    @Cacheable(value = "getInfoById", condition = "#uid>50")
    public int getInfoByIdWithCondition(int uid){
        LOG.info("getInfoByIdWithCondition executed!!!");

        return uid + 100;
    }

    @CacheEvict("getInfoById")
    public void remove(int uid){
        LOG.info("remove uid:{}", uid);
    }

}

package com.yl.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
@Repository
public class RedisTemplateHash1 {
    private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateHash1.class);

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    HashOperations<String, String, String> hashOperations;

    public void add2Hash(){
        hashOperations.put("hash1", "name", "tom");
        hashOperations.put("hash1", "address", "guangzhou");
        hashOperations.put("hash1", "sex", "f");
    }

    public void add2HanshWithSerializer(){
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(serializer);

        hashOps.put("hash1", "name", "tom");
        hashOps.put("hash1", "address", "guangzhou");
        hashOps.put("hash1", "sex", "f");
    }

    public void getHashKey(){
        //// 没有这一段时会报错，因为上面写数据时用的是 add2HanshWithSerializer() 函数
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(serializer);
        ////

        String hashValue = hashOps.get("hash1", "name");
        System.out.println("hashValue: " + hashValue);


        //----------------
        // 方案二  不行
        /*RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(serializer);

        String hashValue = hashOperations.get("hash1", "name");
        System.out.println("hashValue: " + hashValue);*/
        //----------------


    }

    public void getMutiKey(){
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        RedisSerializer<String> serializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(serializer);

        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("address");
        list.add("sex");
        List<String> results = hashOps.multiGet("hash1", list);
        for(String value: results){
            System.out.println("hashValue: " + value);
        }

    }



}

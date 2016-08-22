package com.yl.redis;

import com.yl.redis.entity.User;
import com.yl.redis.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by Administrator on 2016/6/6.
 */
public class AppMain {
    private static final Logger LOG = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //-------------Cache-注解-test-begin--------------------------------
        CacheServiceT1 cacheServiceT1 = context.getBean("cacheServiceT1", CacheServiceT1.class);
        // cacheServiceT1.saveInfoById(15);
        // cacheServiceT1.getInfoById(15);

        /*User user = null;
        cacheServiceT1.setUser(user);*/

        // cacheServiceT1.getInfoById(15);

        //----------unless-begin-------------------
        // cacheServiceT1.getInfoByIdWithUnless(20);
        //----------unless-end---------------------

        //----------condition-begin-------------------
        // cacheServiceT1.getInfoByIdWithCondition(30);
        //----------condition-end---------------------

        //----------remove-begin-------------------
        // cacheServiceT1.remove(15);
        //----------remove-end---------------------

        //-------------Cache-注解-test-end----------------------------------

        //-------------RedisTemplate-test-begin--------------------------------
        // User user1 = new User(23, "john");

        /*User user1 = new User(33, "tom");
        RedisTemplateT1 redisTemplateT1 = context.getBean("redisTemplateT1", RedisTemplateT1.class);
        // redisTemplateT1.save(user1);
        // redisTemplateT1.read(33);
        redisTemplateT1.delete(33);*/
        //-------------RedisTemplate-test-end----------------------------------


        //-------------RedisTemplate-list-begin--------------------------------
        // RedisTemplateT2 redisTemplateT2 = context.getBean("redisTemplateT2", RedisTemplateT2.class);
        // redisTemplateT2.listAdd();
        // redisTemplateT2.addList();
        // redisTemplateT2.removeListKey();
        // 少了读取 list
        //-------------RedisTemplate-list-end----------------------------------

        //-------------StringRedisTemplate-list-begin--------------------------------
        /*StringRedisTemplate stringRedisTemplate = context.getBean("stringRedisTemplate", StringRedisTemplate.class);
        RedisTemplateString redisTemplateString = new RedisTemplateString(stringRedisTemplate);
        redisTemplateString.writeAndRead();*/
        //-------------StringRedisTemplate-list-end----------------------------------


        //-------------StringRedisTemplate-hash-begin----------------------------------
        // RedisTemplateHash1 redisTemplateHash1 = context.getBean("redisTemplateHash1", RedisTemplateHash1.class);
        // redisTemplateHash1.add2Hash();
        // redisTemplateHash1.add2HanshWithSerializer();
        // redisTemplateHash1.getHashKey();
        // redisTemplateHash1.getMutiKey();
        //-------------StringRedisTemplate-hash-end------------------------------------

        //-------------VideoPcu-begin------------------------------------
        RedisVideoPcuT1 redisVideoPcuT1 = context.getBean("redisVideoPcuT1", RedisVideoPcuT1.class);
        redisVideoPcuT1.get();
        // redisVideoPcuT1.setVideoPcu();
        // redisVideoPcuT1.mutiGet();
        //-------------VideoPcu-end--------------------------------------

    }

}

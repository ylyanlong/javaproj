package com.yl.redis;

import com.yl.redis.entity.User;
import com.yl.redis.service.CacheServiceT1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        cacheServiceT1.remove(15);
        //----------remove-end---------------------

        //-------------Cache-注解-test-end----------------------------------

    }

}

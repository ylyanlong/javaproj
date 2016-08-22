package com.yl.spring.mybatis;

import com.yl.spring.mybatis.service.VideoPcuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/6/22.
 */
public class AppMain {
    private static final Logger LOG = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LOG.info("application start!!!");

        // 将数据库里面为 datetime 类型的 转换为 Java 里的 Date 类型
        //--------------datetime 类型取出-begin------------------------------------
        VideoPcuService videoPcuService = context.getBean("videoPcuService", VideoPcuService.class);
        videoPcuService.getUid2numInfo();
        //--------------datetime类型取出-end--------------------------------------
    }
}

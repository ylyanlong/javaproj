package com.yl.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanlong on 2016/5/4.
 */
public class AppMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

       /* Hello hello = context.getBean("hello", Hello.class);
        hello.sayHello();*/

        Knight knight = context.getBean("knight", Knight.class);
        knight.embarkOnQuest();

        /*SlayDragonQuest slayDragonQuest = context.getBean("quest", SlayDragonQuest.class);
        slayDragonQuest.embark();*/

        /*Minstrel minstrel = context.getBean("minstrel", Minstrel.class);
        minstrel.singAfterQuest();*/
    }
}

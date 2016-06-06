package com.yl.spring.aop;

import com.yl.spring.aopannotation.Magician2;
import com.yl.spring.aopxml.*;
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

        // Knight knight = context.getBean("knight", Knight.class);
        // knight.embarkOnQuest();

        /*SlayDragonQuest slayDragonQuest = context.getBean("quest", SlayDragonQuest.class);
        slayDragonQuest.embark();*/

        /*Minstrel minstrel = context.getBean("minstrel", Minstrel.class);
        minstrel.singAfterQuest();*/

        //--------------AOP-XML-配置-begin-------------------------
        // 直接使用这个类还不行
        /*Juggler juggler = context.getBean("duke", Juggler.class);
        juggler.perform();*/
        // 可用
        /*Performer juggler = context.getBean("duke", Performer.class);
        juggler.perform();*/

        // 有参数的情况
        /*Thinker thinker = context.getBean("volunteer", Thinker.class);
        thinker.thinkOfSomething("how to be the best one");
        Magician mindReader = context.getBean("magician", Magician.class);
        System.out.println("intercept: " + mindReader.getThoughts());*/

        // 引入新功能
        // 有报错
        /*GraciousContestant juggler = context.getBean("duke", GraciousContestant.class);
        juggler.receiveAward();*/

        /*Contestant juggler = context.getBean("duke", Contestant.class);
        juggler.receiveAward();*/
        //--------------AOP-XML-配置-end---------------------------

     //--------------AOP-注解-配置-begin---------------------------
     // Performer performer = context.getBean("duke", Juggler.class);  // 有报错
     /*Performer performer = context.getBean("duke", Performer.class);
     performer.perform();*/

     // 处理有参数的情况
     /*Thinker thinker = context.getBean("volunteer", Thinker.class);
     thinker.thinkOfSomething("how to be the best one!!");
     Magician2 mindReader = context.getBean("magician2", Magician2.class);
     System.out.println("intercept: " + mindReader.getThoughts());*/

     // 标注引入
     /*Contestant juggler = context.getBean("duke", Contestant.class);
     juggler.receiveAward();*/
     //--------------AOP-注解-配置-end-----------------------------

     //--------------AOP-ASPECTJ-begin------------------------------
     Performer performer = context.getBean("duke", Performer.class);
     performer.perform();
     //--------------AOP-ASPECTJ-end--------------------------------

    }
}

package com.yl.spring.service;

import com.yl.spring.beans.LeaderA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/3/12.
 */
public class AppMain {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
        //----------------------------HelloWorld--------------------------------------
        // ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        /*HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();*/
        //----------------------------HelloWorld--------------------------------------

        //----------------------------aother-method-------------------------------------
        /*String[] resource = new String[] { "classpath:/application-context-service.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
        context.start();

        PaybillInfoWorker paybillInfoWorker = new PaybillInfoWorker();  // 因为里面有用 AutoWried 所以不能直接NEW
        PaybillInfoWorker paybillInfoWorker = (PaybillInfoWorker)context.getBean("paybillInfoWorker");
        paybillInfoWorker.execute();*/
        //----------------------------aother-method-------------------------------------


        /*LeaderA leader1 = context.getBean("leader1", LeaderA.class);
        leader1.work();*/

        /*LeaderA leader2 = context.getBean("leader2", LeaderA.class);
        leader2.work();*/

        /*LeaderA leader3 = context.getBean("leader3", LeaderA.class);
        leader3.work();*/

        LeaderA leader4 = context.getBean("leader4", LeaderA.class);
        leader4.work();

    }
}

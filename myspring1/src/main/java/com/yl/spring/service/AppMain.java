package com.yl.spring.service;

import com.yl.spring.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/3/12.
 */
public class AppMain {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
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

        /*LeaderA leader4 = context.getBean("leader4", LeaderA.class);
        leader4.work();*/

        //-------------BeanScope-test-begin----------------------
        /*BeanScope beanScope = context.getBean("beanScope", BeanScope.class);
        beanScope.printCount();

        BeanScope beanScope2 = context.getBean("beanScope", BeanScope.class);
        beanScope2.printCount();*/
        //-------------BeanScope-test-end------------------------

        //-------------init-destroy-test-begin----------------------
        /*InitDestroyBean initDestroyBean = context.getBean("initDestroyBean", InitDestroyBean.class);
        initDestroyBean.print();*/
        //-------------init-destroy-test-end----------------------

        //-------------setter-inject-test-begin----------------------
        /*BeanSetterInject beanSetterInject = context.getBean("beanSetterInject", BeanSetterInject.class);
        System.out.println("age:" + beanSetterInject.getAge());
        beanSetterInject.getiLanguage().sayHello();*/
        //-------------setter-inject-test-end----------------------

        //-------------collection-inject-test-begin----------------------
        // BeanCollectionInject beanCollectionInject = context.getBean("beanCollectionInject", BeanCollectionInject.class);
        // beanCollectionInject.showLanguage();

        //BeanMapInject beanMapInject = context.getBean("beanMapInject", BeanMapInject.class);
        //beanMapInject.show();

        /*BeanMapIntergeInject beanMapIntergeInject = context.getBean("beanMapIntergeInject", BeanMapIntergeInject.class);
        beanMapIntergeInject.show();*/

        //BeanPropInject beanPropInject = context.getBean("beanPropInject", BeanPropInject.class);
        //beanPropInject.show();
        //-------------collection-inject-test-end------------------------

        //-------------null-inject-test-begin----------------------
        // BeanNullInject beanNullInject = context.getBean("beanNullInject", BeanNullInject.class);
        // beanNullInject.show();
        //-------------null-inject-test-end----------------------

        //-------------SpEL-inject-test-begin----------------------
        // SpELLiteral spELLiteral = context.getBean("spELLiteral", SpELLiteral.class);
        // spELLiteral.show();
        SpELReference spELReference = context.getBean("spELReference", SpELReference.class);
        spELReference.show();
        //-------------SpEL-inject-test-end------------------------

    }
}

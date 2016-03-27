package com.yl.spring.service;

import com.yl.spring.beans.PythonLanguage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/3/21.
 */
public class AppMain2 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        PythonLanguage py1 = context.getBean("pythonLanguage", PythonLanguage.class);
        py1.sayHello();
        System.out.println("count:" + PythonLanguage.getCount());
        System.out.println("obj num:" + py1.getObjCount());

        PythonLanguage py2 = context.getBean("pythonLanguage", PythonLanguage.class);
        py2.sayHello();
        System.out.println("count:" + PythonLanguage.getCount());
        System.out.println("obj num:" + py2.getObjCount());

        PythonLanguage py3 = context.getBean("pythonLanguage", PythonLanguage.class);
        py3.sayHello();
        System.out.println("count:" + PythonLanguage.getCount());
        System.out.println("obj num:" + py3.getObjCount());
    }
}

package com.yl.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ProgrammerB {
    @Autowired
    private HelloWorld helloWorld;  // 注意使用 Autowired 标注属性时是没有 setter()

    public void show(){
        helloWorld.getMessage();
    }
}

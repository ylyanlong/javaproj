package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/15.
 */
public class AutowiringBeanBycst {
    private HelloWorld helloWorld;

    public AutowiringBeanBycst(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }

    public void show(){
        helloWorld.getMessage();
    }

}

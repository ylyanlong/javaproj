package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/15.
 */
public class AutowiringBeanBytype1 {
    private HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void show(){
        // helloWorld.setMessage("hello show");
        // helloWorld.getMessage();
    }
}

package com.yl.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ProgrammerA {
    private HelloWorld helloWorld;

    public ProgrammerA() {
    }

    @Autowired
    public ProgrammerA(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    // @Autowired
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void show(){
        helloWorld.getMessage();
    }

    // @Autowired
    public void setMyHello(HelloWorld helloWorld){
        System.out.println("ProgrammerA setMyHello");
        this.helloWorld = helloWorld;
    }
}

package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/3/12.
 */
public class HelloWorld {
    private String message;

    public HelloWorld() {
    }

    public HelloWorld(String message) {
        this.message = message;
    }

    public String getMessage() {
        System.out.println("message:" + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

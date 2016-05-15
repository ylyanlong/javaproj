package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/15.
 */
public class HelloBean {
    private String message;

    public String getMessage() {
        System.out.println("HelloBean getMessage");
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

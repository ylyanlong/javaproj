package com.yl.spring.aopxml;

/**
 * Created by Administrator on 2016/5/21.
 */
public class Magician implements MindReader {
    private String thoughts;

    public String getThoughts() {
        return thoughts;
    }

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("intecepting volunteer`s thoughts");
        this.thoughts = thoughts;
    }
}

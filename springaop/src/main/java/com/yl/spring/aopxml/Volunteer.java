package com.yl.spring.aopxml;

/**
 * Created by Administrator on 2016/5/21.
 */
public class Volunteer implements Thinker {
    private String thoughts;

    public String getThoughts() {
        return thoughts;
    }

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }
}

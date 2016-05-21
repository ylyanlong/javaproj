package com.yl.spring.aopxml;

/**
 * Created by Administrator on 2016/5/21.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("Juggling " + beanBags + " beanBags");
    }
}

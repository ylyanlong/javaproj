package com.yl.spring.aopxml;

/**
 * Created by Administrator on 2016/5/21.
 */
public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("GraciousContestant receiveAward");
    }
}

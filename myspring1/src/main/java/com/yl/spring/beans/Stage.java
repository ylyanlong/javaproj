package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Stage {
    private Stage(){}

    private static class StageSingletonHolder{
        static Stage instance = new Stage();
    }

    public static Stage getInstance(){
        return StageSingletonHolder.instance;
    }
}

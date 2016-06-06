package com.yl.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Apple extends Fruit {

    @Override
    public void showName(int num){
    //public void showName(double num){  // 没有 @Override 注解时即使参数类型不对也不对报错，加上后编译器会做检查
        System.out.println("apple:" + num);
    }

    /*@Override  // 私有方法不能用覆写
    public String privateMentod(int a){
        return "apple";
    }*/

    @Override
    public void taste(){}

    // @SuppressWarnings(value = {"unchecked", "fallthrough"})
    @SuppressWarnings({"unchecked", "fallthrough"})
    public void showAttrs(){
        try {
            int b = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        List list = new ArrayList();
        list.add("color");
    }

    @SuppressWarnings({"deprecation"})
    public static void main(String[] args){

        int a = 0;

        Apple apple = new Apple();
        apple.showName(10);
        apple.showAttrs();
        apple.doNotUse();
    }
}

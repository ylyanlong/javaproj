package com.yl.annotation;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Fruit {
    @Deprecated
    private String name;

    private String privateMentod(int a){
        return "private";
    }


    @Deprecated
    public void doNotUse(){
        System.out.println("doNotUse");
    }

    @Deprecated
    public void taste(){}

    public void showName(int num){
        System.out.println("fruit:" + num);
    }


    public static void main(String[] args){
        Fruit fruit = new Fruit();
        fruit.taste();
        fruit.showName(5);
    }

}

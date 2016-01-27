package com.yl.classprac;

/**
 * Created by leon on 2015/10/30.
 */
public class SingletonT2 {
    private static SingletonT2 instance = new SingletonT2();
    public static int NUM = 5;

    private SingletonT2(){
        System.out.println("SingletonT2 exe");
    }

    public static SingletonT2 getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("createString");
    }

    public static void main(String[] args){
        // SingletonT2.createString();
        // SingletonT2.createString();
        System.out.println(SingletonT2.NUM);
    }
}

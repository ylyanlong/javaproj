package com.yl.classprac;

/**
 * Created by leon on 2015/10/30.
 */
public class SingletonT1 {
    public static  int NUM = 30;

//    static {
//        System.out.println("static begin");
//        SingletonT1.NUM = 50;
//        System.out.println("static end");
//    }

    private SingletonT1(){
        System.out.println("SingletonT1 exec");
    }

    public static void main(String[] args){
        System.out.println("NUM=" + SingletonT1.NUM);
    }
}

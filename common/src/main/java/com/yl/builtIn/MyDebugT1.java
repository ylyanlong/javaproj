package com.yl.builtIn;

/**
 * Created by Administrator on 2016/4/9.
 */
public class MyDebugT1 {
    private int base;

    public MyDebugT1(){}

    public MyDebugT1(int base){
        this.base = base;
    }

    public int add(int a, int b){
        int c= a + b + this.base;
        return c;
    }

    public static void main(String[] args){
        MyDebugT1 myDebugT1 = new MyDebugT1(50);
        int d = myDebugT1.add(12, 20);
        System.out.println("d:" + d);
    }
}

package com.yl.thread;

import java.util.Date;

/**
 * Created by leon on 2015/9/17.
 */

class MyThreadImp1 extends Thread{
    public void run(){
        System.out.println("time1:" + new Date() );
    }
}

public class MyThreadT1 {
    public static void main(String[] args){
        MyThreadImp1 myThreadImp1 = new MyThreadImp1();
        myThreadImp1.start();

        Thread thread2 = new Thread(){
            public void run(){
                System.out.println("time2: " + new Date());
            }
        };
        thread2.start();

        Runnable runnable1 = new Runnable() {
            public void run() {
                System.out.println("time3: " + new Date() );
            }
        };
        Thread thread3 = new Thread(runnable1);
        thread3.start();
    }
}

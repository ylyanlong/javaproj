package com.yl.thread;

/**
 * Created by Administrator on 2016/2/20.
 */

class MyTheadImp extends Thread{
    public void run(){
        System.out.println("MyTheadImp");
    }
}

class MyThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThreadRunnable");
    }
}

public class MyThreadT3 {
    public static void main(String[] args){
        MyTheadImp myTheadImp = new MyTheadImp();
        myTheadImp.start();

        Thread thread = new Thread(new MyThreadRunnable());
        thread.start();
    }
}

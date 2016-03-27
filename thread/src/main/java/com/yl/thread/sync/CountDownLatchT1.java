package com.yl.thread.sync;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/3/26.
 */
public class CountDownLatchT1 {
    public static void main(String[] args){
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(){
            public void run(){
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000 * 5);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000 * 8);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

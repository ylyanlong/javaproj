package com.yl.thread.sync;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/3/28.
 */
public class ThreadPollT1 {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new MyTask1());
        executorService.execute(new MyTask1());
        executorService.execute(new MyTask1());
        executorService.execute(new MyTask1());
        executorService.execute(new MyTask1());
        executorService.shutdown();
    }


    public static class MyTask1 implements Runnable{

        @Override
        public void run() {
            System.out.println("MyTask1 begin: " + Thread.currentThread().getName() + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyTask1 end: " + Thread.currentThread().getName() + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        }
    }

}

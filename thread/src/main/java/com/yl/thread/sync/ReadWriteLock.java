package com.yl.thread.sync;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ReadWriteLock {
    private Object data = null;
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void get(){
        System.out.println("enter get " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        rwlock.readLock().lock();

        try {
            System.out.println("begin read " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            // Thread.sleep(1000 * 2);
            Thread.sleep(1000 * 20);
            System.out.println("读出的数据:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
        System.out.println("leave get " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    public void put(Object data){
        System.out.println("enter put " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        // rwlock.writeLock().lock();

        try {
            Thread.sleep(1000 * 5);
            rwlock.writeLock().lock();
            System.out.println("begin write " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            // Thread.sleep(1000 * 10);
            Thread.sleep(1000 * 1);
            System.out.println("end write " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            this.data = data;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }

        System.out.println("leave put " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args){
        final ReadWriteLock readWriteLock = new ReadWriteLock();

        for(int i = 0; i < 1; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.get();
                }
            }).start();
        }

        for(int i = 0; i < 1; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.put(new Random().nextInt(20));
                }
            }).start();
        }
    }


}

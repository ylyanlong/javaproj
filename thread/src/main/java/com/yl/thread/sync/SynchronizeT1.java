package com.yl.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/2/27.
 *  说明了加锁的函数，对不加锁的函数不会导致阻塞；所有需要仔细考虑好哪些操作需要加锁。
 */
public class SynchronizeT1 {
    private static Account account = new Account();

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new AddAccount());
        executorService.execute(new SetAccount());
        executorService.execute(new GetAccount());
        executorService.execute(new AddAccount());

        executorService.shutdown();

        System.out.println("exit main");
    }

    private static class AddAccount implements Runnable{

        @Override
        public void run() {
            account.Addnum();
        }
    }

    private static class SetAccount implements Runnable{

        @Override
        public void run() {
            account.setNum(10);
        }
    }

    private static class GetAccount implements Runnable{

        @Override
        public void run() {
            account.getNum();
        }
    }

    private static class Account {
        private  int num = 0;

        public int getNum() {
            System.out.println("begin getNum");
            System.out.println("end getNum");
            return num;
        }

        public void setNum(int num) {
            System.out.println("begin setNum");
            this.num = num;
            System.out.println("end setNum");
        }

        public synchronized void Addnum(){
            System.out.println("begin Addnum");
            int temp = num;
            temp++;
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num = temp;
            System.out.println("end Addnum");
        }
    }

}

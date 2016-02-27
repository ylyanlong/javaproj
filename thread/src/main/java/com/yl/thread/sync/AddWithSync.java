package com.yl.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/2/27.
 */
public class AddWithSync {
    private static Account account = new Account();

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 30; ++i){
            executorService.execute(new AddAccount());
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){

        }

        System.out.println("final num: " + account.getNum());

    }


    private static class AddAccount implements Runnable{

        @Override
        public void run() {
            account.add();
        }
    }

    private static class Account{
        private  int num = 0;

        public int getNum() {
            return num;
        }

        public synchronized void add(){
            int temp = num;
            temp = temp + 1;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            num = temp;
        }
    }
}

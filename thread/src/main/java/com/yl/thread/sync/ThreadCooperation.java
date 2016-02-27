package com.yl.thread.sync;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/2/27.
 */
public class ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();

        System.out.println("exit main");
    }

    public static class DepositTask implements Runnable{
        private static volatile boolean runningFlg = true;
        private Scanner scanner = new Scanner(System.in);

        @Override
        public void run() {

            try {
                while (runningFlg){
                    System.out.print("input deposit amount:");
                    int num = scanner.nextInt();
                    if(num < 0){
                        runningFlg = false;
                        break;
                    }

                    account.deposit(num);

                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            account.withdraw(10);
        }
    }

    private static class Account{
        private Lock lock = new ReentrantLock();
        private Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public Lock getLock() {
            return lock;
        }

        public void withdraw(int amount){
            lock.lock();

            try {
                while (balance < amount){
                    System.out.println("wait for a deposit");
                    newDeposit.await();
                }

                balance -= amount;
                System.out.println("withdraw: " + amount + "  balance: " + balance);

            }  catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void deposit(int amount){
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount + "  cur balance:" + balance);
                newDeposit.signalAll();
            } finally {
                lock.unlock();
            }


        }

    }
}

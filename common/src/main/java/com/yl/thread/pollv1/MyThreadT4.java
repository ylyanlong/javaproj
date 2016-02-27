package com.yl.thread.pollv1;

/**
 * Created by Administrator on 2016/2/20.
 */

class MyPrintChar implements Runnable{
    private char char2print;
    private int printNum;

    public MyPrintChar(char c, int num){
        char2print = c;
        printNum = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < printNum; ++i){
            System.out.print(" " + char2print);
            // Thread.yield();
        }
    }
}

class MyPrintNum implements Runnable{
    private int nums;

    public MyPrintNum(int printNum){
        nums = printNum;
    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        for(int i = 0; i < nums; ++i){
            System.out.print(" " + i);
            // Thread.yield();
        }
    }
}

class MyPrintNumJoin implements Runnable{
    private int nums;
    Thread thread;

    public MyPrintNumJoin(int printNum, Thread otherThread){
        nums = printNum;
        thread = otherThread;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < nums; ++i) {
                System.out.print(" " + i);
                // Thread.yield();
                if (i == 2) {
                    // thread.join();
                    thread.join(2);
                }
            }// end for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MyThreadT4 {
    public static void main(String[] args){
        Thread charThread = new Thread(new MyPrintChar('b', 2000));
        // charThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("charThread Priority:" + charThread.getPriority());
        charThread.start();


        /*Thread numThread = new Thread(new MyPrintNum(20));
        // numThread.setPriority(Thread.MIN_PRIORITY);
        System.out.println("numThread Priority:" + numThread.getPriority());
        numThread.start();*/

        Thread numThreadJoin = new Thread(new MyPrintNumJoin(2000, charThread));
        numThreadJoin.start();
    }
}

package com.yl.thread.pollv1;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2015/11/24.
 */

class GenerateUUID implements Runnable {
    private String  threadName;
    private static final int COUNT = 2000000; // 200W

    public GenerateUUID(String p_threadName){
        threadName = p_threadName;
    }

    public void run() {
        long timeStart_ms = System.currentTimeMillis();
        for(int i = 0; i < COUNT; ++i){
            UUID.randomUUID();
        }

        long duration_ms = System.currentTimeMillis() - timeStart_ms;
        System.out.println("duration :" + duration_ms);
        double rate = COUNT * 1000 / duration_ms;
        System.out.println(threadName + " : " + rate + "/s");
    }
}

class GenerateAtomLong implements Runnable{
    private static final AtomicLong s_atomicLong = new AtomicLong();
    private static final int COUNT = 2000000; // 200W
    private String threadName;

    public GenerateAtomLong(String p_threadName){
        threadName = p_threadName;
    }

    public void run() {
        long timeStart_ms = System.currentTimeMillis();
        for(int i = 0; i < COUNT; ++i){
            s_atomicLong.getAndIncrement();
        }

        long duration_ms = System.currentTimeMillis() - timeStart_ms;
        System.out.println("duration :" + duration_ms);
        double rate = COUNT * 1000 / duration_ms;
        System.out.println(threadName + " : " + rate + "/s");
    }
}

class GenerateGivenNumUUID implements Runnable {
    private String  threadName;
    private int count;

    public GenerateGivenNumUUID(String p_threadName, int p_count){
        threadName = p_threadName;
        count = p_count;
        System.out.println(threadName + " : " + count);
    }

    public void run() {
        long timeStart_ms = System.currentTimeMillis();
        for(int i = 0; i < count; ++i){
            UUID.randomUUID();
        }

        long duration_ms = System.currentTimeMillis() - timeStart_ms;
        System.out.println("duration :" + duration_ms);
        double rate = count * 1000 / duration_ms;
        System.out.println(threadName + " : " + rate + "/s");
    }
}

public class MyUUIDTest {
    private static final int THREAD_NUM = 2;
    private static final int COUNT_NUM = 2000000;

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

        //---------------
//        for(int i = 0; i < THREAD_NUM; ++i){
//            executor.execute(new GenerateUUID(String.valueOf(i)) );
//        }

//        for(int i = 0; i < THREAD_NUM; ++i){
//            executor.execute(new GenerateGivenNumUUID(String.valueOf(i), (int)(COUNT_NUM/THREAD_NUM)) );
//        }

        for (int i = 0; i < THREAD_NUM; ++i) {
            executor.execute(new GenerateAtomLong(String.valueOf(i)));
        }

//        executor.execute(new GenerateUUID("t1") );
//        executor.execute(new GenerateUUID("t2") );
//        executor.execute(new GenerateUUID("t3") );
//        executor.execute(new GenerateUUID("t4") );
//        executor.execute(new GenerateUUID("t5") );
//
//        executor.execute(new GenerateUUID("t6") );
//        executor.execute(new GenerateUUID("t7") );
//        executor.execute(new GenerateUUID("t8") );
//        executor.execute(new GenerateUUID("t9") );
//        executor.execute(new GenerateUUID("t10") );
        //---------------

        executor.shutdown();
    }
}

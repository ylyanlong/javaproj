package com.yl.thread;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/2/20.
 */
public class TaskMain {
    private static final Logger LOG = LoggerFactory.getLogger(TaskMain.class);
    private static final String THREAD_PROCTASK1 = "THREAD_PROCTASK1";
    private static final String THREAD_CHECKTASK1 = "THREAD_CHECKTASK1";

    public static void main(String[] args){
        TaskQueue taskQueue = new TaskQueue();
        CheckQueue checkQueue = new CheckQueue();

        ProcTask procTask1 = new ProcTask(THREAD_PROCTASK1, taskQueue, checkQueue);
        procTask1.start();

        CheckTask checkTask1 = new CheckTask(THREAD_CHECKTASK1, checkQueue);
        checkTask1.start();

        WorkTask1 workTask1 = new WorkTask1(taskQueue);
        workTask1.start();

        try {
            Thread.sleep(1000*60*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        procTask1.stopThread();
        checkTask1.stopTask();

        LOG.info("exit main");
    }
}

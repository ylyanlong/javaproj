package com.yl.thread.pollv1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/2/20.
 */

class MyTask1 extends BaskTask{
    private static final Logger LOG = LoggerFactory.getLogger(MyTask1.class);


    public MyTask1(long timeout){
        super(timeout);
    }

    public void proc() throws InterruptedException {
        LOG.info("begin MyTask1 proc");
        Thread.sleep(1000 * 8);
        LOG.info("end MyTask1 proc");
    }
}

class MyTask2 extends BaskTask{
    private static final Logger LOG = LoggerFactory.getLogger(MyTask2.class);

    public MyTask2(long timeout){
        super(timeout);
    }

    public void proc(){
        LOG.info("begin MyTask2 proc");
        LOG.info("end MyTask2 proc");
    }
}

public class WorkTask1 extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(WorkTask1.class);
    private TaskQueue taskQueue;
    private static final long TIMEOUT_2S = 1000*2;


    public WorkTask1(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public void run(){
        MyTask2 myTask2 = new MyTask2(TIMEOUT_2S);
        MyTask1 myTask1 = new MyTask1(TIMEOUT_2S);
        try {
            // taskQueue.putTaskQueue1(myTask2);
            taskQueue.putTaskQueue1(myTask1);
        } catch (InterruptedException e) {
            LOG.error("InterruptedException:{}", e.getMessage());
        }

        LOG.info("WorkTask1 exit");
    }
}

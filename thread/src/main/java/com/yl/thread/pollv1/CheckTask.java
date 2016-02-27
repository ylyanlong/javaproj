package com.yl.thread.pollv1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/2/20.
 */
public class CheckTask extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(CheckTask.class);
    private CheckQueue checkQueue;
    private volatile boolean runningFlg = true;

    public CheckTask(String threadName, CheckQueue checkQueue){
        super(threadName);
        this.checkQueue = checkQueue;
    }

    public void stopTask(){
        runningFlg = false;
        interrupt();
        LOG.info("thread {} stopTask", this.getName());
    }

    @Override
    public void run() {
        while (runningFlg){
            try {
                Thread.sleep(200);
                checkQueue.checkTasks();
            } catch (InterruptedException e) {
                LOG.info("InterruptedException:{}", e.getMessage());
            }
        }

        LOG.info("thread {} exit!", this.getName());
    }
}

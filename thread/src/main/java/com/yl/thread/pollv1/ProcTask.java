package com.yl.thread.pollv1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/2/20.
 */
public class ProcTask extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(ProcTask.class);
    private TaskQueue taskQueue;  // 如果是静态的就不用这么做了，静态的在一定程度上减少了接口入侵，但也增加了阅读的复杂度
    private CheckQueue checkQueue;  // 如果是静态的就不用这么做了，静态的在一定程度上减少了接口入侵，但也增加了阅读的复杂度
    private volatile boolean runningFlg = true;

    public ProcTask(String threadName, TaskQueue taskQueue, CheckQueue checkQueue){
        super(threadName);
        this.taskQueue = taskQueue;  // 如果是静态的，会减少这些
        this.checkQueue = checkQueue;
    }

    public void stopThread(){
        runningFlg = false;
        interrupt();  // 解除读阻塞状态
        LOG.info("thread {} stopThread", this.getName());
    }

    @Override
    public void run() {

        while (runningFlg){
            try {
                /*if(isInterrupted()){
                    LOG.info("isInterrupted");  // 好处没看明白作用是啥
                    break;
                }*/

                BaskTask task = taskQueue.takeTaskQueue1();

                // 检查队列设置
                task.setThread(this);
                checkQueue.putCheckQueue(task);

                // 运行
                task.proc();
                task.setRunning(false);  // 表示运行结束

            } catch (InterruptedException e) {
                // e.printStackTrace();
                LOG.info("InterruptedException:{}", e.getMessage());
                // 回调超时处理函数等
            }
        }

        LOG.info("thread {} exit", this.getName());
    }
}

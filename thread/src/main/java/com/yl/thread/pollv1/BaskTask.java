package com.yl.thread.pollv1;

/**
 * Created by Administrator on 2016/2/20.
 */
public class BaskTask {
    private long beginTime;  // 毫秒
    private long timeout;  // 超时时间，毫秒
    private long endTime;  // 毫秒
    private Thread thread;  // 运行该Task 的thread
    private volatile boolean running = true;


    /*public BaskTask() {
    }*/

    public BaskTask(long timeout) {
        this.timeout = timeout;
        beginTime = System.currentTimeMillis();
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void proc() throws InterruptedException{// 可以像 C++ 那样，定义成带参数的形式

    }
}

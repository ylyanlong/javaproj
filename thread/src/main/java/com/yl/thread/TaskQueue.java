package com.yl.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/2/20.
 */
public class TaskQueue {
    private static final Logger LOG = LoggerFactory.getLogger(TaskQueue.class);
    private LinkedBlockingQueue<BaskTask> m_queue1 = new LinkedBlockingQueue<>();

    public void putTaskQueue1(BaskTask task) throws InterruptedException {
        m_queue1.put(task);
        LOG.info("after putTaskQueue1 size:{}", m_queue1.size());
    }

    public BaskTask takeTaskQueue1() throws InterruptedException {
        BaskTask baskTask = null;  // 是否会有初始值 null，普通类型呢?
        baskTask = m_queue1.take();
        LOG.info("after takeTaskQueue1 size:{}", m_queue1.size());

        return baskTask;
    }
}

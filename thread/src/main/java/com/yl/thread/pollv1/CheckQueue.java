package com.yl.thread.pollv1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/2/20.
 */
public class CheckQueue {
    private static final Logger LOG = LoggerFactory.getLogger(CheckQueue.class);
    private LinkedBlockingQueue<BaskTask> m_checkqueue = new LinkedBlockingQueue<>();

    public void putCheckQueue(BaskTask baskTask){
        try {
            m_checkqueue.put(baskTask);
            LOG.info("after putCheckQueue size:{}", m_checkqueue.size());
        } catch (InterruptedException e) {
            //e.printStackTrace();
            LOG.error("putCheckQueue error:{}", e.getMessage());
        }
    }

    public BaskTask takeCheckQueue(){  // 此处其实也可以改为只删除，不返回的函数
        BaskTask baskTask = null;
        try {
            baskTask = m_checkqueue.take();
        } catch (InterruptedException e) {
            // e.printStackTrace();
            LOG.error("takeCheckQueue error:{}", e.getMessage());
        }

        return baskTask;
    }

    public BaskTask checkTasks(){  // 同理，此处其实也可以改为只删除，不返回的函数
        BaskTask baskTask = null;

        Iterator<BaskTask> iterator = m_checkqueue.iterator();
        while (iterator.hasNext()){
            baskTask = iterator.next();
            long timenow = System.currentTimeMillis();
            long timebegin = baskTask.getBeginTime();
            long timeout = baskTask.getTimeout();

            if(timenow - timebegin >= timeout){  // 已经超时
                baskTask.getThread().interrupt();
                baskTask.setEndTime(timenow);
                m_checkqueue.remove(baskTask);
                LOG.info("checkTimeout timeout remove task size:{}", m_checkqueue.size());
            }

            if(baskTask.isRunning() == false){  // 说明已经运行结束
                m_checkqueue.remove(baskTask);
                LOG.info("checkTimeout normal remove task size:{}", m_checkqueue.size());
            }
        }

        return baskTask;
    }

}

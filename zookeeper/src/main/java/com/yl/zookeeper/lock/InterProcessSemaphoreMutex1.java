package com.yl.zookeeper.lock;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/28.
 */
public class InterProcessSemaphoreMutex1 {
    private static final Logger LOG = LoggerFactory.getLogger(InterProcessSemaphoreMutex1.class);

    private InterProcessSemaphoreMutex lock;


    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        InterProcessSemaphoreMutex1 interProcessMutex1 = new InterProcessSemaphoreMutex1(curatorUtil.getCuratorFramework());
        interProcessMutex1.doWork(80, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public InterProcessSemaphoreMutex1(CuratorFramework client){
        lock = new InterProcessSemaphoreMutex(client, "/ylzktest/lock");
    }

    private void doWork(long time, TimeUnit timeUnit){
        try {
            if(!lock.acquire(time, timeUnit)){
                LOG.info("doWork acquire lock failed!");
                return;
            }
        } catch (Exception e) {
            LOG.error("doWork lock.acquire Exception:{}", ExceptionUtils.getStackTrace(e));
            return;
        }

        // 再次获取，测试可重入性
        /*try {
            if(!lock.acquire(time, timeUnit)){
                LOG.info("doWork2 acquire lock failed!");
                return;
            }
        } catch (Exception e) {
            LOG.error("doWork2 lock.acquire Exception:{}", ExceptionUtils.getStackTrace(e));
            return;
        }*/

        try {
            // 使用共享资源
            LOG.info("doWork: 使用共享资源");
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            LOG.error("doWork InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        } finally {
            LOG.info("release the lock!");
            try {
                lock.release();  // 需要释放两次，否则该线程还会持有锁
                // lock.release();  // 已经测过，确实不可重入，会阻塞住；直到超时
            } catch (Exception e) {
                LOG.error("doWork lock.release Exception:{}", ExceptionUtils.getStackTrace(e));
            }
        }

    }

}

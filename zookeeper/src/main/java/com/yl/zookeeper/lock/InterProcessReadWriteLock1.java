package com.yl.zookeeper.lock;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/29.
 */
public class InterProcessReadWriteLock1 {
    private static final Logger LOG = LoggerFactory.getLogger(InterProcessReadWriteLock1.class);
    private InterProcessReadWriteLock readWriteLock;
    private InterProcessMutex readLock;
    private InterProcessMutex writeLock;

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        InterProcessReadWriteLock1 readWriteLock1 = new InterProcessReadWriteLock1(curatorUtil.getCuratorFramework(),
                "/ylzktest/lock");
        readWriteLock1.doWork(80, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public InterProcessReadWriteLock1(CuratorFramework client, final String lockPath){
        readWriteLock = new InterProcessReadWriteLock(client, lockPath);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    public void doWork(long time, TimeUnit timeUnit){
        try {
            if(!writeLock.acquire(time, timeUnit)){
                LOG.info("writeLock.acquire failed and return");
                return;
            }
        } catch (Exception e) {
            LOG.error("doWork writeLock.acquire Exception:{}", ExceptionUtils.getStackTrace(e));
            return;
        }

        LOG.info("acquired writeLock");

        try {
            readLock.acquire(time, timeUnit);
        } catch (Exception e) {
            LOG.error("doWork() readLock.acquire failed:{}", ExceptionUtils.getStackTrace(e));
        }

        try {
            LOG.info("使用共享资源!!!");
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            LOG.error("doWork() InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                readLock.release();
                LOG.info("已经释放读锁");
            } catch (Exception e) {
                LOG.error("doWork() readLock release error Exception:{}", ExceptionUtils.getStackTrace(e));
            }

            try {
                writeLock.release();
            } catch (Exception e) {
                LOG.error("doWork() writeLock release error Exception:{}", ExceptionUtils.getStackTrace(e));
            }
        }

    }

}

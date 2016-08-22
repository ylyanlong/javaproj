package com.yl.zookeeper.lock;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/29.
 */
public class InterProcessMultiLockDemo1 {
    private static final Logger LOG = LoggerFactory.getLogger(InterProcessMultiLockDemo1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        interProcessMultiLockDemo(curatorUtil.getCuratorFramework());

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public static void interProcessMultiLockDemo(CuratorFramework client){
        InterProcessLock lock1 = new InterProcessMutex(client, "/ylzktest/lock/lock1");
        InterProcessLock lock2 = new InterProcessSemaphoreMutex(client, "/ylzktest/lock/lock2");

        InterProcessMultiLock multiLock = new InterProcessMultiLock(Arrays.asList(lock1, lock2));
        try {
            if(!multiLock.acquire(10, TimeUnit.SECONDS)){
                LOG.info("could not acquire lock!");
            }
        } catch (Exception e) {
            LOG.error("interProcessMultiLockDemo Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("has the lock1:{}", lock1.isAcquiredInThisProcess());
        LOG.info("has the lock2:{}", lock2.isAcquiredInThisProcess());

        try {
            LOG.info("doWork: 使用共享资源");
            TimeUnit.SECONDS.sleep(120);
        } catch (InterruptedException e) {
            LOG.error("interProcessMultiLockDemo() sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                multiLock.release();
            } catch (Exception e) {
                LOG.error("interProcessMultiLockDemo() release Exception:{}", ExceptionUtils.getStackTrace(e));
            }
        }

        LOG.info("end has the lock1:{}", lock1.isAcquiredInThisProcess());
        LOG.info("end has the lock2:{}", lock2.isAcquiredInThisProcess());
    }

}

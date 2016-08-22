package com.yl.zookeeper.lock;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
import org.apache.curator.framework.recipes.locks.Lease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/29.
 */
public class InterProcessSemaphore1 {
    private static final Logger LOG = LoggerFactory.getLogger(InterProcessSemaphore1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        interProcessSemaphoreDemo(curatorUtil.getCuratorFramework(), "/ylzktest/lock", 10);

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public static void interProcessSemaphoreDemo(CuratorFramework client, final String lockPath, final int leaseNum){
        InterProcessSemaphoreV2 interProcessSemaphoreV2 = new InterProcessSemaphoreV2(client, lockPath, leaseNum);
        Collection<Lease> leases = null;
        try {
            leases = interProcessSemaphoreV2.acquire(5);
            LOG.info("interProcessSemaphoreDemo leases size:{}", leases.size());
        } catch (Exception e) {
            LOG.error("interProcessSemaphoreDemo() acquire failed");
        }

        Lease lease = null;
        try {
            lease = interProcessSemaphoreV2.acquire();
            LOG.info("get anthor lease");
        } catch (Exception e) {
            LOG.error("interProcessSemaphoreDemo acquire one failed:{}", ExceptionUtils.getStackTrace(e));
        }

        //----------模拟业务处理-begin-------------------------
        try {
            LOG.info("使用共享资源开始!!!");
            TimeUnit.SECONDS.sleep(80);
            LOG.info("使用共享资源结束!!!");
        } catch (InterruptedException e) {
            LOG.error("doWork() InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }
        //----------模拟业务处理-end---------------------------

        try {
            Collection<Lease> leases2 = interProcessSemaphoreV2.acquire(5, 60, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOG.info("interProcessSemaphoreDemo acquire leases2 failed:{}", ExceptionUtils.getStackTrace(e));
        }

        interProcessSemaphoreV2.returnLease(lease);
        LOG.info("returnLease done!");

        interProcessSemaphoreV2.returnAll(leases);
        LOG.info("returnAll done!");

    }

}

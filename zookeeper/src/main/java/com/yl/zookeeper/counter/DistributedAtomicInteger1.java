package com.yl.zookeeper.counter;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/4.
 */
public class DistributedAtomicInteger1 {
    private static final Logger LOG = LoggerFactory.getLogger(DistributedAtomicInteger1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        distributedAtomicIntegerDemo(curatorUtil.getCuratorFramework(), "/ylzktest/counter");

        /*try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    private static void distributedAtomicIntegerDemo(CuratorFramework client, final String counterPath){
        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client, counterPath, new RetryNTimes(3, 1000));
        AtomicValue<Integer> rc = null;

        /*try {
            LOG.info("前期等待 begin");
            TimeUnit.SECONDS.sleep(60);
            LOG.info("前期等待 end");
        } catch (InterruptedException e) {
            LOG.error("InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/

        try {
            LOG.info("开始增加");
            rc = atomicInteger.add(3);  // 之前是5
            LOG.info("结束增加");
        } catch (Exception e) {
            LOG.error("distributedAtomicIntegerDemo atomicInteger.add() Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("atomicInteger.add() preValue:{}, postValue:{}", rc.preValue(), rc.postValue());
        LOG.info("Result:{}", rc.succeeded());

        /*try {
            LOG.info("后期等待 begin");
            TimeUnit.SECONDS.sleep(60);
            LOG.info("后期等待 end");
        } catch (InterruptedException e) {
            LOG.error("InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/

        // 获取
        /*try {
            rc = atomicInteger.get();
        } catch (Exception e) {
            LOG.error("distributedAtomicIntegerDemo atomicInteger.get() Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("atomicInteger.get()  value:{}", rc.postValue());
        LOG.info("Result:{}", rc.succeeded());*/


    }

}

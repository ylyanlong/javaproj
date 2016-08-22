package com.yl.zookeeper.barrier;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/1.
 */
public class DistributedBarrier2 {
    private static final Logger LOG = LoggerFactory.getLogger(DistributedBarrier2.class);
    private static DistributedBarrier barrier;

    public static void main(String[] args){
        final CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                barrier = new DistributedBarrier(curatorUtil.getCuratorFramework(), "/ylzktest/barrier");
                LOG.info("{} 设置 barrier", Thread.currentThread().getName());
                try {
                    barrier.setBarrier();
                } catch (Exception e) {
                    LOG.error("barrier.setBarrier Exception:{}", ExceptionUtils.getStackTrace(e));
                }

                try {
                    barrier.waitOnBarrier();
                } catch (Exception e) {
                    LOG.error("barrier.waitOnBarrier Exception:{}", ExceptionUtils.getStackTrace(e));
                }

                LOG.info("准备启动......");
            }
        }).start();

        try {
            LOG.info("主线程休眠中");
            TimeUnit.SECONDS.sleep(60);
            LOG.info("主线程休眠结束");
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

}

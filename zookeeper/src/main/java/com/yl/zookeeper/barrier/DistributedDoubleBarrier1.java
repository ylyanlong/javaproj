package com.yl.zookeeper.barrier;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/1.
 */
public class DistributedDoubleBarrier1 {
    private static final Logger LOG = LoggerFactory.getLogger(DistributedDoubleBarrier1.class);
    private static DistributedDoubleBarrier barrier;

    public static void main(String[] args){
        final CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                barrier = new DistributedDoubleBarrier(curatorUtil.getCuratorFramework(), "/ylzktest/barrier", 2);
                try {
                    TimeUnit.SECONDS.sleep(80);
                } catch (InterruptedException e) {
                    LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
                }

                LOG.info("{} 准备进入 barrier", Thread.currentThread().getName());

                try {
                    barrier.enter();
                    LOG.info("{} 已经进入 barrier", Thread.currentThread().getName());
                } catch (Exception e) {
                    LOG.error("barrier.enter() Exception:{}", ExceptionUtils.getStackTrace(e));
                }

                try {
                    LOG.info("开始业务处理");
                    TimeUnit.SECONDS.sleep(80);
                    LOG.info("业务处理结束");
                } catch (InterruptedException e) {
                    LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
                }

                try {
                    LOG.info("准备离开");
                    barrier.leave();
                    LOG.info("已经离开");
                } catch (Exception e) {
                    LOG.error("barrier.leave() Exception:{}", ExceptionUtils.getStackTrace(e));
                }


                LOG.info("准备启动......");
            }
        }).start();

        try {
            LOG.info("主线程休眠中");
            TimeUnit.SECONDS.sleep(200);
            LOG.info("主线程休眠结束");
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

}

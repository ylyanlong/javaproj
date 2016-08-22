package com.yl.zookeeper.leader;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/27.
 */
public class LeaderLatch2 {
    private static final Logger LOG = LoggerFactory.getLogger(LeaderLatch2.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);
        leaderSelect(curatorUtil.getCuratorFramework(), "/ylzktest/leaderSelect");

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public static void leaderSelect(CuratorFramework client, final String latchPath){
        LeaderLatch leaderLatch = new LeaderLatch(client, latchPath);
        try {
            leaderLatch.start();
        } catch (Exception e) {
            LOG.error("leaderSelect start Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        // 休眠，等待选举出 leader
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            LOG.error("leaderSelect sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        if(leaderLatch.hasLeadership()){
            LOG.info("current leader is:{}", leaderLatch.getId());
            LOG.info("leaderSelect preparing release the leader");
            try {
                leaderLatch.close();
                LOG.info("leaderSelect release the leader done!");
            } catch (IOException e) {
                LOG.error("leaderSelect close IOException:{}", ExceptionUtils.getStackTrace(e));
            }
        }

        LOG.info("leaderSelect() leave");
    }
}

package com.yl.zookeeper.leader;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/27.
 */
public class LeaderSelector1 extends LeaderSelectorListenerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(LeaderSelector1.class);
    private LeaderSelector selector;

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);
        LeaderSelector1 leaderSelector1 = new LeaderSelector1(curatorUtil.getCuratorFramework(), "/ylzktest/leaderSelect");
        leaderSelector1.start();

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        leaderSelector1.close();
        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    public LeaderSelector1(CuratorFramework client, final String leaderPath){
        selector = new LeaderSelector(client, leaderPath, this);
        selector.autoRequeue();
    }

    public void start(){
        selector.start();
        LOG.info("selector started");
    }

    public void close(){
        selector.close();
        LOG.info("selector closed");
    }

    @Override
    public void takeLeadership(CuratorFramework client) throws Exception {
        LOG.info("this node is the leader");
        TimeUnit.SECONDS.sleep(10);
        LOG.info("takeLeadership() leave");
    }
}

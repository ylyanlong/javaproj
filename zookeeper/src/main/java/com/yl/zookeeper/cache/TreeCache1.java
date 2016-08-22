package com.yl.zookeeper.cache;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.utils.ZKPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/4.
 */
public class TreeCache1 {
    private static final Logger LOG = LoggerFactory.getLogger(TreeCache1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        TreeCache treeCache = new TreeCache(curatorUtil.getCuratorFramework(), "/ylzktest/cache");
        try {
            treeCache.start();
        } catch (Exception e) {
            LOG.error("treeCache.start() Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        addListener(treeCache);
        // distributedAtomicIntegerDemo(curatorUtil.getCuratorFramework(), "/ylzktest/counter");

        try {
            TimeUnit.SECONDS.sleep(240);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        treeCache.close();
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    private static void addListener(final TreeCache cache){
        TreeCacheListener listener = new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
                switch (event.getType()){
                    case NODE_ADDED:
                        LOG.info("TreeNode added:{}, value:{}", ZKPaths.getNodeFromPath(event.getData().getPath()),
                                new String(event.getData().getData()));
                        break;
                    case NODE_UPDATED:
                        LOG.info("TreeNode changed:{}, value:{}", ZKPaths.getNodeFromPath(event.getData().getPath()),
                                new String(event.getData().getData()));
                        break;
                    case NODE_REMOVED:
                        LOG.info("TreeNode removed:{}", ZKPaths.getNodeFromPath(event.getData().getPath()) );
                        break;
                    default:
                        LOG.info("Other event:{}", event.getType().name());
                        break;
                }
            }
        };

        cache.getListenable().addListener(listener);
    }

}

package com.yl.zookeeper.util;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.*;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2016/6/25.
 */
public class CuratorUtil {
    private static final Logger LOG = LoggerFactory.getLogger(CuratorUtil.class);

    private CuratorFramework curatorFramework;

    public CuratorUtil(String zkAddress){
        curatorFramework = CuratorFrameworkFactory.newClient(zkAddress, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.getCuratorListenable().addListener(new NodeEventListener());
        curatorFramework.start();
    }

    /**
     * 创建znode
     * @param nodeName
     * @param value
     * @return
     */
    public boolean createNode(String nodeName, String value){
        boolean rtn = false;
        try {
            Stat stat = curatorFramework.checkExists().forPath(nodeName);
            if(stat == null){
                String opResult = null;
                if(Strings.isNullOrEmpty(value)){
                    opResult = curatorFramework.create().creatingParentsIfNeeded().forPath(nodeName);
                } else {
                    opResult = curatorFramework.create().creatingParentsIfNeeded().forPath(nodeName,
                            value.getBytes(Charsets.UTF_8) );
                }

                rtn = Objects.equal(nodeName, opResult);
            }
        } catch (Exception e) {
            LOG.error("createNode Exception {}", ExceptionUtils.getStackTrace(e));
        }

        return rtn;
    }

    /**
     * 异步创建 znode，目的是熟悉 异步调用的方式，使用默认的 EventThread
     * @param nodeName
     * @param value
     * @return
     */
    public boolean createNodeByAsynDefault(String nodeName, String value){
        boolean rtn = false;
        try {
            Stat stat = curatorFramework.checkExists().forPath(nodeName);
            if(stat == null){
                String opResult = curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                        LOG.info("createNodeByAsynDefault threadName:{}, code:{}, type:{}", Thread.currentThread().getName(),
                                curatorEvent.getResultCode(), curatorEvent.getType());
                    }
                }).forPath(nodeName, value.getBytes(Charsets.UTF_8));

                rtn = Objects.equal(nodeName, opResult);
            }
        } catch (Exception e) {
            LOG.error("createNodeWitchAsyn Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return rtn;
    }

    /**
     * 异步创建 znode，目的是熟悉异步方式，使用自定义 Executor
     * @param nodeName
     * @param value
     * @param executor
     * @return
     */
    public boolean createNodeByAsynExecutor(String nodeName, String value, Executor executor){
        boolean rtn = false;
        try {
            Stat stat = curatorFramework.checkExists().forPath(nodeName);
            if(stat == null){
                String opResult = curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        LOG.info("createNodeByAsynExecutor threadName:{}, code:{}, type:{}", Thread.currentThread().getName(),
                                event.getResultCode(), event.getType());
                    }
                }, executor).forPath(nodeName, value.getBytes(Charsets.UTF_8));

                rtn = Objects.equal(nodeName, opResult);
            }
        } catch (Exception e) {
            LOG.error("createNodeByAsynExecutor Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return rtn;
    }

    /**
     * 创建 EPHEMERAL 节点
     * @param nodeName
     * @param value
     * @return
     */
    public boolean createEphemeralNode(String nodeName, String value){
        boolean rtn = false;

        try {
            Stat stat = curatorFramework.checkExists().forPath(nodeName);
            if(stat == null){
                String opResult = null;
                if(Strings.isNullOrEmpty(value)){
                    opResult = curatorFramework.create()
                            .creatingParentsIfNeeded()
                            .withMode(CreateMode.EPHEMERAL)
                            .forPath(nodeName);
                } else {
                    opResult = curatorFramework.create()
                            .creatingParentsIfNeeded()
                            .withMode(CreateMode.EPHEMERAL)
                            .forPath(nodeName, value.getBytes(Charsets.UTF_8));
                }

                rtn = Objects.equal(nodeName, opResult);
            }
        } catch (Exception e) {
            LOG.error("createEphemeralNode Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return rtn;
    }

    /**
     * 获取 znode 的值
     * 未考虑路径给错或者不存在的情况，生产环境时需要加上相关判断
     * @param nodeName
     * @return
     */
    public String getNodeValue(final String nodeName){
        String value = null;

        try {
            value = new String(curatorFramework.getData().forPath(nodeName), Charsets.UTF_8);
        } catch (Exception e) {
            LOG.error("getNodeValue Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return value;
    }

    /**
     * 获取 znode 的值和 znode 的 stat 信息
     * 未考虑路径给错或者不存在的情况，生产环境时需要加上相关判断
     * @param nodeName
     * @param stat
     * @return
     */
    public String getNodeValueAndStat(final String nodeName, Stat stat){
        String value = null;

        try {
            value = new String(curatorFramework.getData().storingStatIn(stat).forPath(nodeName), Charsets.UTF_8);
        } catch (Exception e) {
            LOG.error("getNodeValueAndStat Exception:{}", ExceptionUtils.getStackTrace(e));
        }
        LOG.info("getNodeValueAndStat stat:{}", stat.toString());

        return value;
    }

    /**
     * 更新节点
     * @param nodeName
     * @param value
     * @return
     */
    public boolean updateNode(String nodeName, String value){
        boolean rtn = false;

        try {
            Stat stat = curatorFramework.checkExists().forPath(nodeName);
            if(stat != null){
                Stat opResult = curatorFramework.setData().forPath(nodeName, value.getBytes(Charsets.UTF_8));
                rtn = opResult != null;
            }
        } catch (Exception e) {
            LOG.info("error updateNode Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return rtn;
    }

    /**
     * 删除 znode
     * @param nodeName
     */
    public void deleteNode(String nodeName){
        try {
            curatorFramework.delete().deletingChildrenIfNeeded().forPath(nodeName);
        } catch (Exception e) {
            LOG.error("deleteNode Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * 找到指定节点下所有子节点的名称与值
     * @param nodeName
     * @return
     */
    public Map<String, String> listChildrenDetail(String nodeName){
        Map<String, String> map = Maps.newHashMap();
        try {
            GetChildrenBuilder childrenBuilder = curatorFramework.getChildren();
            List<String> children = childrenBuilder.forPath(nodeName);
            GetDataBuilder dataBuilder = curatorFramework.getData();
            if(children != null){
                for(String child: children){
                    String propPath = ZKPaths.makePath(nodeName, child);
                    map.put(child, new String(dataBuilder.forPath(propPath), Charsets.UTF_8));
                }
            }

        } catch (Exception e) {
            LOG.error("listChildrenDetail Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return map;
    }

    /**
     * 列出指定 znode 的子节点的名称
     * @param nodeName
     * @return
     */
    public List<String> listChildren(String nodeName){
        List<String> children = Lists.newArrayList();
        GetChildrenBuilder childrenBuilder = curatorFramework.getChildren();
        try {
            children = childrenBuilder.forPath(nodeName);
        } catch (Exception e) {
            LOG.error("listChildren Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        return children;
    }

    /**
     * 增加监听
     * true 的话是为 node 本身增加监听，false 是为 node 的子节点增加监听
     * @param nodeName
     * @param isSelf
     */
    public void addWatch(String nodeName, boolean isSelf){
        try {
            if(isSelf){
                curatorFramework.getData().watched().forPath(nodeName);
            } else {
                curatorFramework.getChildren().watched().forPath(nodeName);
            }
        } catch (Exception e) {
            LOG.error("addWatch () Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * 增加监听
     * true 的话是为 node 本身增加监听，false 是为 node 的子节点增加监听
     * @param nodeName
     * @param isSelf
     * @param watcher
     */
    public void addWatch(String nodeName, boolean isSelf, Watcher watcher){
        try {
            if(isSelf){
                curatorFramework.getData().usingWatcher(watcher).forPath(nodeName);
            } else {
                curatorFramework.getChildren().usingWatcher(watcher).forPath(nodeName);
            }
        } catch (Exception e) {
            LOG.error("addWatch Watcher Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * 增加监听
     * true 的话是为 node 本身增加监听，false 是为 node 的子节点增加监听
     * @param nodeName
     * @param isSelf
     * @param watcher
     */
    public void addWatch(String nodeName, boolean isSelf, CuratorWatcher watcher){
        try {
            if(isSelf){
                curatorFramework.getData().usingWatcher(watcher).forPath(nodeName);
            } else {
                curatorFramework.getChildren().usingWatcher(watcher).forPath(nodeName);
            }
        } catch (Exception e) {
            LOG.error("addWatch CuratorWatcher Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }


    /**
     * 销毁资源
     * @return
     */
    public void destroy(){
        if(curatorFramework != null){
            curatorFramework.close();
        }
    }

    /**
     * NodeCache
     * @param client
     * @param path
     * @param dataIsCompressed
     */
    public void addNodeCache(CuratorFramework client, final String path, boolean dataIsCompressed){
        final NodeCache nodeCache = new NodeCache(client, path, dataIsCompressed);
        try {
            nodeCache.start(true);
        } catch (Exception e) {
            LOG.error("addNodeCache start Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData childData = nodeCache.getCurrentData();
                if(childData == null){
                    LOG.info("addNodeCache node data updated, childData==null, the znode may be deleted");
                } else {
                    LOG.info("addNodeCache node data updated, data:{}", new String(childData.getData()) );
                }

            }
        });
    }

    /**
     * PathChildrenCache
     * @param client
     * @param path
     * @param cacheData
     */
    public void addPathChildrenCache(CuratorFramework client, final String path, boolean cacheData){
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path, cacheData);
        try {
            pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        } catch (Exception e) {
            LOG.error("addPathChildrenCache start Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()){
                    case CHILD_ADDED:
                        LOG.info("addPathChildrenCache CHILD_ADDED:{}", event.getData());
                        break;
                    case CHILD_UPDATED:
                        LOG.info("addPathChildrenCache CHILD_UPDATED:{}", event.getData());
                        break;
                    case CHILD_REMOVED:
                        LOG.info("addPathChildrenCache CHILD_REMOVED:{}", event.getData());
                        break;
                    default:
                        LOG.info("addPathChildrenCache default:{}", event.getData());
                        break;
                }
            }
        });

    }

    public CuratorFramework getCuratorFramework() {
        return curatorFramework;
    }
}

// 监听器
final class NodeEventListener implements CuratorListener{
    private static final Logger LOG = LoggerFactory.getLogger(NodeEventListener.class);

    @Override
    public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
        LOG.info("NodeEventListener curatorEvent:{}", curatorEvent.toString());
        final WatchedEvent watchedEvent = curatorEvent.getWatchedEvent();
        if(watchedEvent != null){
            LOG.info("eventReceived, watchedEvent state:{}, type:{}", watchedEvent.getState(), watchedEvent.getType());
            if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected){
                switch (watchedEvent.getType()){
                    case NodeChildrenChanged:
                        // TODO
                        LOG.info("NodeEventListener NodeChildrenChanged");
                        break;
                    case NodeDataChanged:
                        // TODO
                        LOG.info("NodeEventListener NodeDataChanged");
                        break;
                    case NodeCreated:
                        // TODO
                        LOG.info("NodeEventListener NodeCreated");
                        break;
                    case NodeDeleted:
                        // TODO
                        LOG.info("NodeEventListener NodeDeleted");
                        break;
                    default:
                        LOG.info("NodeEventListener default");
                        break;
                }
            }

        }

    }
}

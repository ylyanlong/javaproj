package com.yl.zookeeper.biz;

import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/25.
 */
public class CuratorTest {
    private static final Logger LOG = LoggerFactory.getLogger(CuratorTest.class);
    // private static final String ZKADDRESS = "116.31.122.111:2181,116.31.122.112:2181,116.31.122.113:2181";

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        //---------------创建/删除/读取/更新 节点相关-begin--------------------------------
        // curatorUtil.createNode("/ylzktest/test1", "你好abc");
        // curatorUtil.createNode("/ylzktest/test2", "你好123");
        // curatorUtil.updateNode("/ylzktest/test1", "你好abc2");
        // curatorUtil.deleteNode("/ylzktest/test1");

        // get 节点信息
        // String value = curatorUtil.getNodeValue("/ylzktest/test1");
        // LOG.info("value:{}", value);

        ////
        /*String value = curatorUtil.getNodeValue("/ylzktest/counter");
        LOG.info("value size:{}", value.length());
        LOG.info("value:{}", value.getBytes());*/

        ////

        // Stat stat = new Stat();
        // String value = curatorUtil.getNodeValueAndStat("/ylzktest/test1", stat);
        // LOG.info("value:{}, stat:{}", value, stat.toString());

        // 异步方式
        // curatorUtil.createNodeByAsynDefault("/ylzktest/test4", "ASYN4");

        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        curatorUtil.createNodeByAsynExecutor("/ylzktest/test5", "ASYN5", executorService);
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            LOG.info("TimeUnit.SECONDS.sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }
        executorService.shutdown();*/
        //---------------创建/删除/读取/更新 节点相关-end----------------------------------

        //---------------列出子节点相关-begin--------------------------------
        // 列出名称
        /*List<String> childrenList = curatorUtil.listChildren("/ylzktest");
        for(String child: childrenList){
            System.out.println("child: " + child);
        }*/

        // 列出名称和值
        /*Map<String, String> childrenName2value = curatorUtil.listChildrenDetail("/ylzktest");
        for(Map.Entry<String, String> entry: childrenName2value.entrySet()){
            LOG.info("childrenName2value: {}={}", entry.getKey(), entry.getValue());
        }*/
        //---------------列出子节点相关-end-----------------------------------

        //---------------监听相关-begin-----------------------------------
        /*curatorUtil.addWatch("/ylzktest", false);  // 只能用一次

        try {
            TimeUnit.SECONDS.sleep(600);
        } catch (InterruptedException e) {
            LOG.info("TimeUnit.SECONDS.sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/
        //---------------监听相关-end-------------------------------------

        //---------------EPHEMERAL节点相关-begin-------------------------------------
        /*curatorUtil.createEphemeralNode("/ylzktest/test2", "ephemeral");

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            LOG.info("TimeUnit.SECONDS.sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/
        //---------------EPHEMERAL节点相关-end---------------------------------------

        //---------------事件监听相关-begin---------------------------------------
        // znode 节点被创建和更新时有收到事件，删除时也会收到事件
        // 子节点的创建、更新、删除 不会收到通知
        // curatorUtil.addNodeCache(curatorUtil.getCuratorFramework(), "/ylzktest/test6", false);

        // 孩子节点的增加/更新/删除 会收到通知
        // 节点自身的更新/删除 不会收到通知
        // 孙子节点的增加/更新/删除 不会收到通知
        /*curatorUtil.addPathChildrenCache(curatorUtil.getCuratorFramework(), "/ylzktest/test6", true);

        try {
            TimeUnit.SECONDS.sleep(300);
        } catch (InterruptedException e) {
            LOG.info("TimeUnit.SECONDS.sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }*/
        //---------------事件监听相关-end-----------------------------------------

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");

    }



}

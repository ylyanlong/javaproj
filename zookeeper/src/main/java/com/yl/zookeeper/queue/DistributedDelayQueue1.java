package com.yl.zookeeper.queue;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.queue.*;
import org.apache.curator.framework.state.ConnectionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/29.
 */
public class DistributedDelayQueue1 {
    private static final Logger LOG = LoggerFactory.getLogger(DistributedDelayQueue1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        putAndConsumeMsg(curatorUtil.getCuratorFramework(), "/ylzktest/queue");

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

    private static void putAndConsumeMsg(CuratorFramework client, final String path){
        QueueConsumer<String> consumer = createQueueConsumer();
        QueueBuilder<String> builder = QueueBuilder.builder(client, consumer, createQueueSerializer(), path);
        DistributedDelayQueue<String> queue = builder.buildDelayQueue();
        try {
            queue.start();
            LOG.info("queue started");
        } catch (Exception e) {
            LOG.error("queue.start() Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        LOG.info("begin to put");
        try {
            queue.put("test_1", System.currentTimeMillis() + 1000 * 30);
            queue.put("test_2", System.currentTimeMillis() + 1000 * 50);
            queue.put("test_3", System.currentTimeMillis() + 1000 * 70);
        } catch (Exception e) {
            LOG.info("queue.put Exception:{}", ExceptionUtils.getStackTrace(e));
        }
        LOG.info("end to put");

        try {
            LOG.info("preparing sleep");
            TimeUnit.SECONDS.sleep(240);
            LOG.info("end sleep");
        } catch (InterruptedException e) {
            LOG.info("sleep() InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                queue.close();
            } catch (IOException e) {
                LOG.error("queue.close() IOException:{}", ExceptionUtils.getStackTrace(e));
            }
        }

    }

    private static QueueSerializer<String> createQueueSerializer(){
        return new QueueSerializer<String>() {
            @Override
            public byte[] serialize(String item) {
                return item.getBytes();
            }

            @Override
            public String deserialize(byte[] bytes) {
                return new String(bytes);
            }
        };
    }

    private static QueueConsumer<String> createQueueConsumer(){
        return new QueueConsumer<String>() {
            @Override
            public void consumeMessage(String message) throws Exception {
                LOG.info("consume one message:{}", message);
                TimeUnit.SECONDS.sleep(15);
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                LOG.info("connection new state:{}", newState.name() );
            }
        };
    }
}

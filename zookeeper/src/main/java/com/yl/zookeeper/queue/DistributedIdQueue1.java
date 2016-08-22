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
public class DistributedIdQueue1 {
    private static final Logger LOG = LoggerFactory.getLogger(DistributedIdQueue1.class);

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
        DistributedIdQueue<String> queue = builder.buildIdQueue();
        try {
            queue.start();
            LOG.info("queue started");
        } catch (Exception e) {
            LOG.error("queue.start() Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        for(int i = 0; i < 8; i++){
            try {
                queue.put("test_" + i, "id_" + i);
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                LOG.info("queue.put Exception:{}", ExceptionUtils.getStackTrace(e));
            }
        }

        LOG.info("begin to remove");
        try {
            queue.remove("id_3");
            queue.remove("id_4");
            queue.remove("id_5");
            queue.remove("id_6");
            queue.remove("id_7");
        } catch (Exception e) {
            LOG.error("queue.remove Exception:{}", ExceptionUtils.getStackTrace(e));
        }
        LOG.info("end to remove");

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

    // 是否是一个阻塞接口
    private static QueueConsumer<String> createQueueConsumer(){
        return new QueueConsumer<String>() {
            @Override
            public void consumeMessage(String message) throws Exception {
                LOG.info("consume one message:{}", message);
                TimeUnit.SECONDS.sleep(28);
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                LOG.info("connection new state:{}", newState.name() );
            }
        };
    }
}

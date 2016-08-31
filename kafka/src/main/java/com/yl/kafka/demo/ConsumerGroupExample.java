package com.yl.kafka.demo;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ConsumerGroupExample {
    private static final String TOPIC = "ylkafkat2";
    private static final String ZKPATH = "116.31.122.111:2181,116.31.122.112:2181,116.31.122.113:2181";
    private static final String GROUPNAME = "gp_ylt2";
    private static final int THREADNUM = 2;

    private final ConsumerConnector consumer;
    private final String topic;
    private ExecutorService exector;

    public ConsumerGroupExample(String a_zookeeper, String a_groupId, String a_topic){
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));
        topic = a_topic;
    }

    public void shutdown(){
        if(consumer != null){
            consumer.shutdown();
        }
        if(exector != null){
            exector.shutdown();  // 对已经在运行线程的影响
        }

        try {
            if(!exector.awaitTermination(5000, TimeUnit.MILLISECONDS)){
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }

    public void run(int a_numThreads){
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(a_numThreads));
        Map<String, List<KafkaStream<byte[], byte[]>> > consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
        // now launch all threads
        exector = Executors.newFixedThreadPool(a_numThreads);
        // now create an object to consume the messages
        int threadNumber = 0;
        for(final KafkaStream stream: streams){
            exector.submit(new ConsumeTest1(stream, threadNumber));
            threadNumber++;
        }
    }

    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId){
        Properties props = new Properties();
        props.put("auto.offset.reset", "smallest"); //必须要加，如果要读旧数据
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }

    public static void main(String[] args){
        ConsumerGroupExample consumerGroupExample = new ConsumerGroupExample(ZKPATH, GROUPNAME, TOPIC);
        consumerGroupExample.run(THREADNUM);

        try {
            Thread.sleep(1000 * 60 * 8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumerGroupExample.shutdown();
    }

}

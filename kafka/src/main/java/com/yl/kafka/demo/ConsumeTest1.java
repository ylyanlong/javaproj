package com.yl.kafka.demo;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;


/**
 * Created by Administrator on 2015/8/17.
 */
public class ConsumeTest1 implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;

    public ConsumeTest1(KafkaStream a_stream, int a_threadNum){
        m_stream = a_stream;
        m_threadNumber = a_threadNum;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext()){
            // 从使用上看，应该是 hasNext() 阻塞了，怎样测试这一功能
            // 与传统迭代器不同，消息流迭代器永不停止。如果当前没有消息，迭代器将阻塞，直到有新的消息发布到该话题
            System.out.println("Thread= " + m_threadNumber + " , tname: " + Thread.currentThread().getName() + " , msg:" + new String(it.next().message()) );
        }
        System.out.println("Shutting down thread: " + m_threadNumber);  // 什么时候可以执行到这句
    }
}

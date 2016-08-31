package com.yl.kafka.demo;



import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2016/8/22.
 */
public class KafkaProducerT1 {
    private static final String TOPIC = "ylkafkat2";
    private static final String KAFKA_HOSTS = "kafka1:9092,kafka2:9092,kafka3:9092,kafka4:9092";
    // private static final String KAFKA_HOSTS = "kafka3:9092";  // 说明只要有一个可以连通的就可以了
    private static final boolean sync = false;
    private static int counter = 0;

    public static void main(String[] args){
        send2kafka();
    }

    public static void send2kafka(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_HOSTS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        //------------------
        Scanner scanner = new Scanner(System.in);
        System.out.print("cur key: " + counter + " , input value:");
        try {
            String value = scanner.nextLine();
            while (!value.equals("quit") ){
                System.out.println("value:" + value);

                //----------------------------------
                String key = String.valueOf(counter);
                //-----------------
                ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC, key, value);

                //-----------------
                if(sync){
                    try {
                        producer.send(producerRecord).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 发送方式一
                    // producer.send(producerRecord);

                    //-----发送方式二--begin-------
                    producer.send(producerRecord, new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if(exception != null){
                                exception.printStackTrace();
                            } else {
                                System.out.println("metadata, offset:" + metadata.offset() + " , partition:" +
                                        metadata.partition() + " , topic:" + metadata.topic());
                            }
                        }
                    });
                    //-----发送方式二--end---------
                }
                //------------------------------------
                counter++;
                System.out.print("cur key: " + counter + " , input value:");
                value = scanner.nextLine();
            }// end while
        } catch (Exception e) {  //
            e.printStackTrace();
        }

        // 清理工作
        producer.close();
        //------------------

    }

}

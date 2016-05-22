package com.yl.thrift.hello;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/5/22.
 */
public class HelloNonblockingClient2 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8300;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args){
        // 设置传输通道，对于非阻塞式服务，需要使用TFrameTransport，它将数据分块发出去
        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
        // 协议要和服务端一致
        // 使用高密度二进制协议
        // TProtocol protocol = new TCompactProtocol(transport);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWorld.Client client = new HelloWorld.Client(protocol);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        try {
            String result = client.sayHello("tom");
            System.out.println("result: " + result);
        } catch (TException e) {
            e.printStackTrace();
        }

        transport.close();
    }

}

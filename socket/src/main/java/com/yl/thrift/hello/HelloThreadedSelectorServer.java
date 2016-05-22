package com.yl.thrift.hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/5/22.
 * 多线程 Half-sync/Half-async的服务模型
 * 需要指定为TFramed 数据传输方式
 */
public class HelloThreadedSelectorServer {
    // 注册端口
    public static final int SERVER_PORT = 8300;

    public static void main(String[] args) throws TTransportException {
        TProcessor tProcessor = new HelloWorld.Processor<HelloWorld.Iface>(new HelloWorldImpl());
        // 传输方式 - 非阻塞方式
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);
        // 多线程半同步半异步
        TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverSocket);
        tArgs.processor(tProcessor);
        tArgs.transportFactory(new TFramedTransport.Factory());
        // 二进制协议
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 多线程半同步半异步的服务模型
        TServer tServer = new TThreadedSelectorServer(tArgs);
        System.out.println("HelloThreadedSelectorServer starting");
        tServer.serve();
        System.out.println("HelloThreadedSelectorServer started");

    }
}

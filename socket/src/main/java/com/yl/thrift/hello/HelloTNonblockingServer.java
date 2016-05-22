package com.yl.thrift.hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/5/22.
 * 注册服务端，服务端和客户端需要指定TFramedTransport数据传输的方式。TNblockingServer
 */
public class HelloTNonblockingServer {
    // 注册端口
    public static final int SERVER_PORT = 8300;

    public static void main(String[] args) throws TTransportException {
        // 处理器
        TProcessor tProcessor = new HelloWorld.Processor<HelloWorld.Iface>(new HelloWorldImpl());
        // 传输方式 - 非阻塞方式
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);
        // 异步IO，需要使用TFrameTransport，它将分块缓存读取
        TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverSocket);
        tArgs.processor(tProcessor);
        tArgs.transportFactory(new TFramedTransport.Factory());
        // 使用高密度二进制协议
        tArgs.protocolFactory(new TCompactProtocol.Factory());
        // 使用非阻塞式IO，服务端和客户端需要指定TFrameTransport 传输方式
        TServer tServer = new TNonblockingServer(tArgs);
        System.out.println("HelloTNonblockingServer starting");
        tServer.serve();
        System.out.println("HelloTNonblockingServer started");

    }


}

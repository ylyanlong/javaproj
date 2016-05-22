package com.yl.thrift.hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/5/22.
 * 注册服务端，半同步半异步的服务端模型，需要指定为: TFrameTransport传输方式，THsHaServer非阻塞
 */
public class HelloTHsHaServer {
    // 注册端口
    public static final int SERVER_PORT = 8300;

    public static void main(String[] args) throws TTransportException {
        TProcessor tProcessor = new HelloWorld.Processor<HelloWorld.Iface>(new HelloWorldImpl());
        // 传输方式 - 非阻塞方式
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);
        // 半同步半异步
        THsHaServer.Args tArgs = new THsHaServer.Args(serverSocket);
        tArgs.processor(tProcessor);
        tArgs.transportFactory(new TFramedTransport.Factory());
        // 二进制协议
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 半同步半异步的服务模型
        TServer tServer = new THsHaServer(tArgs);
        System.out.println("HelloTHsHaServer starting");
        tServer.serve();
        System.out.println("HelloTHsHaServer startted");

    }
}

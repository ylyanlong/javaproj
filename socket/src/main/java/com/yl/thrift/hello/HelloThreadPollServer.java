package com.yl.thrift.hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/5/22.
 */
public class HelloThreadPollServer {
    public static final int SERVER_PORT = 8300;

    public static void main(String[] args) throws TTransportException {
        TProcessor tProcessor = new HelloWorld.Processor<HelloWorld.Iface>(new HelloWorldImpl());
        // 阻塞IO
        TServerSocket tServerSocket = new TServerSocket(SERVER_PORT);
        // 多线程服务模型
        TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(tServerSocket);
        tArgs.processor(tProcessor);
        // 客户端协议要一致
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求
        TServer tServer = new TThreadPoolServer(tArgs);
        System.out.println("HelloThreadPollServer starting");
        tServer.serve();  // 会阻塞住，因为下面这句没有打印
        System.out.println("HelloThreadPollServer started");


    }
}

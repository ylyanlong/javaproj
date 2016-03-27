package com.yl.thrift.hello;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Administrator on 2016/3/25.
 */
public class HelloTSimpleServer {
    public static final int SERVER_PORT = 8300;

    public static void main(String[] args){
        TProcessor tProcessor = new HelloWorld.Processor<HelloWorld.Iface>(new HelloWorldImpl());
        TServerSocket serverSocket = null;
        try {
            serverSocket = new TServerSocket(SERVER_PORT);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        TServer.Args tArgs = new TServer.Args(serverSocket);
        tArgs.processor(tProcessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(tArgs);
        System.out.println("HelloServer start");
        server.serve();
    }

}

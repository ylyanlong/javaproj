package com.yl.thrift.hello;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/22.
 * 客户端异步调用，服务端需使用TNonblockingServer，THsHaServer
 *
 */
public class HelloAsyncClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8300;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        // 异步调用管理器
        TAsyncClientManager clientManager = new TAsyncClientManager();
        // 设置传输通道，调用非阻塞IO
        TNonblockingTransport transport = new TNonblockingSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        // 协议要和服务端一致
        TProtocolFactory tProtocol = new TBinaryProtocol.Factory();
        HelloWorld.AsyncClient asyncClient = new HelloWorld.AsyncClient(tProtocol, clientManager, transport);
        CountDownLatch latch = new CountDownLatch(1);
        AsyncCallback asyncCallback = new AsyncCallback(latch);
        System.out.println("call method sayHello start ...");
        try {
            asyncClient.sayHello("lilei", asyncCallback);
        } catch (TException e) {
            e.printStackTrace();
        }
        System.out.println("call method sayHello end");
        // 等待完成异步调用
        try {
            boolean wait = latch.await(30, TimeUnit.SECONDS);
            System.out.println("latch.wait=" + wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class AsyncCallback implements AsyncMethodCallback<HelloWorld.AsyncClient.sayHello_call>{
    private CountDownLatch latch;

    public AsyncCallback(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void onComplete(HelloWorld.AsyncClient.sayHello_call sayHello_call) {
        System.out.println("onComplete");
        try {
            System.out.println("AsyncCall result: " + sayHello_call.getResult());
        } catch (TException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    @Override
    public void onError(Exception e) {
        System.out.println("onError: " + e.getMessage() );
        latch.countDown();
    }
}

package com.yl.thrift.hello;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by Administrator on 2016/3/25.
 */
public class HelloClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8300;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args){
        TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWorld.Client client = new HelloWorld.Client(protocol);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        try {
            String result = client.sayHello("jack");
            System.out.println("result:" + result);
        } catch (TException e) {
            e.printStackTrace();
        }

        transport.close();
    }


}

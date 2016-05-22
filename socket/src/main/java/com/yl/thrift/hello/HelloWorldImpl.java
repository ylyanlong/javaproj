package com.yl.thrift.hello;

import org.apache.thrift.TException;

/**
 * Created by Administrator on 2016/3/25.
 */
public class HelloWorldImpl implements HelloWorld.Iface {
    @Override
    public String sayHello(String username) throws TException {
        /*try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return "hello world: " + username;
    }


}

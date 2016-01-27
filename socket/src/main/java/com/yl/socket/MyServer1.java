package com.yl.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/1/21.
 */
public class MyServer1 {
    public static void main(String[] args){
        int port = 10001;
        DataInputStream in = null;
        DataOutputStream out = null;
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("begin accept");

        try {
            socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("after accept");

        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(in.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            out.writeDouble(5.6);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

package com.yl.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2016/1/21.
 */
public class MyClient1 {
    public static void main(String[] args){
        int port = 10001;
        String host = "localhost";
        DataInputStream in = null;
        DataOutputStream out = null;
        Socket socket = null;

        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            out.writeDouble(8.9);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            System.out.println(in.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

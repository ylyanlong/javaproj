package com.yl.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by leon on 2016/1/21.
 */
public class MyClient1 {
    public static void main(String[] args){
        int port = 10001;
        String host = "localhost";
        BufferedReader in = null;
        PrintWriter out = null;
        Socket socket = null;

        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("input cmd:");
        try {
            String cmd = scanner.nextLine();
            while (!cmd.equals("quit")){
                System.out.println("cmd:" + cmd);

                //----------------------------------
                out.print(cmd + "\r\n");
                out.flush();
                // System.out.println("out.flush()");

                try {
                    System.out.println(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //------------------------------------

                System.out.print("input cmd:");
                cmd = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}

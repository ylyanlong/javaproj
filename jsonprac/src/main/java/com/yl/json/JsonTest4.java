package com.yl.json;

import java.io.*;

/**
 * Created by Administrator on 2016/3/20.
 */
public class JsonTest4 {

    public static void main(String[] args){

        File file = new File("entrecom.txt");// 指定要读取的文件
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";// 用来保存每次读取一行的内容
        try {
            /*while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }*/

            line = bufferedReader.readLine();
            System.out.println(line);
            String[] info = line.split("\t", 3);
            System.out.println("size:" + info.length);
            System.out.println("info[0]:" + info[0]);
            System.out.println("info[1]:" + info[1]);
            System.out.println("info[2]:" + info[2]);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();// 关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

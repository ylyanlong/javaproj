package com.yl.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/20.
 */
public class FileT1 {
    public static void main(String[] args){
        // File file1 = new File ("C:\\temp\\myNote.txt");
        // File file2 = new File ("/tmp/myNote.txt"); // in Linux/Unix        unix文件系统的方法
        // File myFile = new File("C:" + File.separator + "jdk1.5.0" + File.separator, "File.java");  最安全的方法
        FileT1 fileT1 = new FileT1();

        // 当前目录创建单个文件
        // fileT1.createFile();

        // 创建目录测试
        // fileT1.mkdirFunc();

        // 创建目录测试: 父目录不存在
        fileT1.mkdirsFunc();

    }

    // 多次运行不会覆盖，会返回false
    private void createFile(){
        File file = new File("temp.txt");

        try {
            System.out.println("createFile rtn:" + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*if(!file.exists()){
            try {
                System.out.println(file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    /* 反复运行不会覆盖，会返回false;
    如果父目录不存在会返回false，不会创建目录
     */
    private void mkdirFunc(){
        final String path = "D:\\data\\test_yl";
        // final String path = "D:\\data\\test_yl2\\test_yl5";
        File file = new File(path);
        System.out.println("mkdirFunc rtn:" + file.mkdir());
    }

    /**
     * 1, 即使父目录不存在会自动创建父目录
     * 2, 已经创建成功后，在目录里面创建文件；再次运行代码，不会覆盖其中的文件或目录
     */
    private void mkdirsFunc(){
        final String path = "D:\\data\\test_yl2\\test_yl5";
        File file = new File(path);
        System.out.println("mkdirsFunc rtn:" + file.mkdirs());
    }

}

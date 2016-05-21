package com.yl.builtIn;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/2/27.
 */
public class ConsoleInput1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /*System.out.print("input a double:");
        double num = scanner.nextDouble();
        System.out.println("num: " + num);*/
        System.out.print("input a line:");
        String line = scanner.nextLine();  // 没有回车换行符
        System.out.println("line:" + line);
        System.out.println("line size:" + line.length());
    }
}

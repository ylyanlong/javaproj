package com.yl.builtIn;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/2/27.
 */
public class ConsoleInput1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("input a double:");
        double num = scanner.nextDouble();
        System.out.println("num: " + num);
    }
}

package com.yl.builtIn;

/**
 * Created by yl on 2015/11/23.
 */
public class MyConsole1 {
    public static void main(String[] args){
        if(args.length != 3){
            System.out.println("args.length != 3");
        }
        else {
            System.out.println("args:" + args[0] + ", " + args[1] + ", " + args[2]);
        }
    }
}

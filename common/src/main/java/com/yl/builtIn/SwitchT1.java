package com.yl.builtIn;

/**
 * Created by Administrator on 2016/5/12.
 */
public class SwitchT1 {
    public static void main(String[] args){
        String cmd = "abc";

        switch (cmd){
            case "yan":
                System.out.println("it is yan");
                break;
            case "long":
                System.out.println("it is long");
                break;
            case "leon":
                System.out.println("it is leon");
                break;
            default:
                System.out.println("it is default");
                break;
        }

    }
}

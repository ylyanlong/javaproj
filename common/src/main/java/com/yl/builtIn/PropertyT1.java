package com.yl.builtIn;

import java.util.Properties;

/**
 * Created by Administrator on 2016/3/26.
 */
public class PropertyT1 {
    public static void main(String[] args){
        Properties properties = new Properties();
        properties.setProperty("test1", "test11");
        properties.setProperty("test2", "test21");
        properties.setProperty("test3", "test31");

        System.out.println(properties.getProperty("test1"));
        System.out.println(properties.getProperty("test2"));
        System.out.println(properties.getProperty("test3"));
    }
}

package com.yl.spring.beans;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanScope {
    private static int count = 0;

    public BeanScope(){
        count++;
    }

    public void printCount(){
        System.out.println("time:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + ", count: " + count);
    }
}

package com.yl.spring.aopxml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Administrator on 2016/5/21.
 */
public class Audience2 {
    public void takeSeats(){
        System.out.println("the audience is taking their seats");
    }

    public void takeOffCellPhones(){
        System.out.println("the audience is take off their cellphones");
    }

    public void applaud(){
        System.out.println("CLAP CLAP CLAP CLAP");
    }

    public void demandRefund(){
        System.out.println("Boo! we want our money back");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis();
            System.out.println("the audience is taking their seats");
            System.out.println("the audience is take off their cellphones");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP CLAP");
            long end = System.currentTimeMillis();
            System.out.println("performance duration: " + (end - start) + "(ms)" );
        }  catch (Throwable throwable) {
            System.out.println("Boo! we want our money back");
            throwable.printStackTrace();
        }
    }
}

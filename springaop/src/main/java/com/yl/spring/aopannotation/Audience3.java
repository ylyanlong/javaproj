package com.yl.spring.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/5/21.
 */
@Component
@Aspect
public class Audience3 {
    // @Pointcut("execution(* com.yl.spring.aopxml.Performer.perform(..))")
    @Pointcut("execution(* *.perform(..))")
    public void performance(){

    }

    /*@Before("performance()")
    public void takeSeats(){
        System.out.println("Audience3: the audience is taking their seats");
    }

    @Before("performance()")
    public void takeOffCellPhones(){
        System.out.println("Audience3: the audience is take off their cellphones");
    }

    @AfterReturning("performance()")
    public void applaud(){
        System.out.println("Audience3: CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Audience3: Boo! we want our money back");
    }*/

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis();
            System.out.println("Audience3: the audience is taking their seats");
            System.out.println("Audience3: the audience is take off their cellphones");
            joinPoint.proceed();
            System.out.println("Audience3: CLAP CLAP CLAP CLAP");
            long end = System.currentTimeMillis();
            System.out.println("Audience3: performance duration: " + (end - start) + "(ms)" );
        }  catch (Throwable throwable) {
            System.out.println("Audience3: Boo! we want our money back");
            throwable.printStackTrace();
        }
    }
}

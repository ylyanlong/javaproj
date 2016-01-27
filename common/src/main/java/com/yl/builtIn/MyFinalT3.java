package com.yl.builtIn;

import java.util.Random;

/**
 * Created by leon on 2015/8/2.
 */
public class MyFinalT3 {
    private static Random random = new Random(47);
    private final int a = random.nextInt(20); // inital when create object
    private static final int b = random.nextInt(20);  // inital when load

    public final static int MY_AGE = 20;
    public static final int MY_HEIGH = 170;

    public static void main(String[] args){
        MyFinalT3 myFinal1 = new MyFinalT3();
        System.out.println("myFinal1 a:" + myFinal1.a);
        System.out.println("myFinal1 b: " + myFinal1.b);

        MyFinalT3 myFinal2 = new MyFinalT3();
        System.out.println("myFinal2 a:" + myFinal2.a);
        System.out.println("myFinal2 b:" + myFinal2.b);

        // MY_AGE = 12;
        // MY_HEIGH = 13;
    }
}

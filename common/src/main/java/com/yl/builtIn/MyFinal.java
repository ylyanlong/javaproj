package com.yl.builtIn;

import java.util.List;
import java.util.Random;

/**
 * Created by leon on 2015/8/2.
 */
public class MyFinal {
    private static Random random = new Random(47);
    private final int a = random.nextInt(20); // inital when create object
    private static final int b = random.nextInt(20);  // inital when load

    public final static int MY_AGE = 20;
    public static final int MY_HEIGH = 170;

    private String combanStr(final int a, final String str){
        // a = 34;
        // str = "long";
        return a + str;
    }

    private void opContain(final List<Integer> list){
        list.add(45);
        // list = new ArrayList<Integer>();
    }

    private void changeLong(Long mylong){
        mylong = Long.valueOf(10); // Unnecessary boxing
        System.out.println("mylong:" + mylong);
    }

    public static void main(String[] args){
        MyFinal myFinal1 = new MyFinal();
        System.out.println("myFinal1 a:" + myFinal1.a);
        System.out.println("myFinal1 b: " + myFinal1.b);

        MyFinal myFinal2 = new MyFinal();
        System.out.println("myFinal2 a:" + myFinal2.a);
        System.out.println("myFinal2 b:" + myFinal2.b);

        System.out.println("random int: " + random.nextInt() );
        System.out.println("random int: " + random.nextInt() );

        System.out.println(myFinal1.combanStr(5, "yan"));


        Long myLong = Long.valueOf(45);  // Unnecessary boxing
        long mynum = myLong;
        System.out.println(mynum);
        long mynum2 = 98;
        myLong = mynum2;
        mynum = myLong;
        System.out.println(mynum);
        // MY_AGE = 12;
        // MY_HEIGH = 13;
        Long myLongT = Long.valueOf(7);  // Unnecessary boxing
        myFinal1.changeLong(myLongT);
        System.out.println("myLongT:" + myLongT);

        Object obj = myLong;
        System.out.println("obj=" + obj);
        System.out.println("(Object)myLong:" + (Object)myLong);  // Casting myLong to Object is redundant

        int i = 5;
        // i++;
        System.out.println("i:" + (i++));

    }
}

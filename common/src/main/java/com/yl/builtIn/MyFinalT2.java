package com.yl.builtIn;

import com.yl.classprac.Circle3;

/**
 * Created by leon on 2015/9/12.
 */
public class MyFinalT2 {
    private static final Circle3 circleObj1 = new Circle3(2.5);
    private final static Circle3 circleObj2 = new Circle3(3.5);

    public static void main(String[] args){
        // circleObj1 = new Circle3(3.3);
        // circleObj2 = new Circle3(4.5);
        MyFinalT2 myFinalT2 = new MyFinalT2();
        circleObj1.setRadius(5.2);
        System.out.println("circleObj1 's radius: " + circleObj1.getRadius());
        System.out.println("adress:" + myFinalT2 );
        System.out.println("test proj");
    }
}

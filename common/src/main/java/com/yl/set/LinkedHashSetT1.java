package com.yl.set;

import java.util.LinkedHashSet;

/**
 * Created by Administrator on 2015/9/8.
 */
public class LinkedHashSetT1 {
    public static void main(String[] args){
        LinkedHashSet<String> set1 = new LinkedHashSet<String>();
        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("San Francisco");
        set1.add("Beijing");
        set1.add("New York");

        System.out.println("set1 is:" + set1);

        for(Object ele: set1){
            System.out.print(ele + "  ");
        }
    }
}

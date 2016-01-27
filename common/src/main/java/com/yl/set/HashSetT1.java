package com.yl.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by leon on 2015/9/8.
 */
public class HashSetT1 {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Begjing");
        set.add("New York");

        System.out.println(set);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext() ){
            System.out.print(iterator.next().toUpperCase() + "  ");
        }

        System.out.println();

        for(Object ele: set){
            System.out.print(ele + "  ");
        }
    }
}

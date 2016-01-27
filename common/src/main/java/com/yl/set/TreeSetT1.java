package com.yl.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by leon on 2015/9/8.
 */
public class TreeSetT1 {
    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println("set: " + set);

        // Set<String> treeSet = new TreeSet<String>(set);  // can not use first()
        TreeSet<String> treeSet = new TreeSet<String>(set);
        System.out.println("treeSet: " + treeSet);

        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last() );
        System.out.println("headSet(): " + treeSet.headSet("New York"));
        System.out.println("tailSet(): " + treeSet.tailSet("New York") );

        System.out.println("Hello");

        System.out.println("lower(\"p\")" + treeSet.lower("P"));
        System.out.println("higher(\"p\")" + treeSet.higher("P"));
        System.out.println("floor(\"P\")" + treeSet.floor("P"));
        System.out.println("ceiling(\"P\")" + treeSet.ceiling("P") );
        System.out.println("pollFirst():" + treeSet.pollFirst() );
        System.out.println("pollLast(): " + treeSet.pollLast() );
        System.out.println("new treeSet: " + treeSet);



    }
}

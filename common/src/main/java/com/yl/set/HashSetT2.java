package com.yl.set;

import java.util.HashSet;

/**
 * Created by leon on 2015/9/8.
 */
public class HashSetT2 {
    public static void main(String[] args){
        HashSet<String> set1 = new HashSet<String>();
        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("San Francisco");
        set1.add("Beijing");
        System.out.println("set1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        set1.remove("London");
        System.out.println("\n set1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        HashSet<String> set2 = set1;
        System.out.println("\n set2 is " + set2);
        System.out.println(set2.size() + " elements in set2");

        HashSet<String> set3 = new HashSet<String>();
        set3.add("London");
        set3.add("Shanghai");
        set3.add("Paris");

        System.out.println("\n set3 is " + set3);
        System.out.println(set3.size() + " elements in set3");

        System.out.println("Taipei in set3: " + set3.contains("Taipei"));

        set2.addAll(set3);
        System.out.println("set2 addAll: " + set2);
        System.out.println("set3 addAll: " + set3);

        set2.removeAll(set3);
        System.out.println("set2 removeAll: " + set2);
        System.out.println("set3 removeAll: " + set3);

        set2.retainAll(set3);
        System.out.println("set2 retainAll: " + set2);
        System.out.println("set3 retainAll: " + set3);

    }
}

package com.yl.list;

import java.util.ArrayList;

/**
 * Created by leaon on 15-9-10.
 */
public class ArrayListT1 {
    public static void main(String[] args){
        ArrayList<String> cityList = new ArrayList<String>();
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Seoul");
        cityList.add("Tokyo");
        System.out.println("cityList size: " + cityList.size());
        System.out.println("is Miami in the list? " + cityList.contains("Miami"));
        System.out.println("the location Denver in the list? " + cityList.indexOf("Denver"));
        System.out.println("is the list empty? " + cityList.isEmpty());
        cityList.add(2, "Xian");
        cityList.remove("Miami");
        cityList.remove(1);
        System.out.println(cityList.toString() );

        for(int i = cityList.size() - 1; i >= 0; i--){
            System.out.print(cityList.get(i) + "  ");
        }
        System.out.println();
    }
}

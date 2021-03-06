package com.yl.map;

import java.util.*;

/**
 * Created by Administrator on 2016/3/24.
 */
public class MyMapT4 {
    public static void main(String[] args){
        /*Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);*/

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(12, 5);
        hashMap.put(12, 7);
        hashMap.put(22, 8);

        Integer rtn = hashMap.put(23, 9);
        if(rtn == null){
            System.out.println("rtn1 is null");
        } else {
            System.out.println("rtn1 is not null");
        }

        rtn = hashMap.put(23, 10);
        if(rtn == null){
            System.out.println("rtn2 is null");
        } else {
            System.out.println("rtn2 is not null");
        }

        Set<Map.Entry<Integer, Integer> > entries = hashMap.entrySet();
        for(Map.Entry<Integer, Integer> ele: entries){
            System.out.println(ele.getKey() + " : " + ele.getValue() );
        }

        // System.out.println("null key:" + linkedHashMap.get("yl"));
    }

}

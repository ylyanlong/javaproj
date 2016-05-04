package com.yl.map;

import java.util.*;

/**
 * Created by Administrator on 2016/4/7.
 */
public class MyMapT5 {
    public static void main(String[] args){
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("col1", "property1");
        linkedHashMap.put("col2", "property2");
        linkedHashMap.put("col3", "property3");
        linkedHashMap.put("col4", "property4");
        linkedHashMap.put("NULL", "property4");

        Set<Map.Entry<String, String> > entries = linkedHashMap.entrySet();
        for(Map.Entry<String, String> ele: entries){
            System.out.println( ele.getKey() + " : " + ele.getValue());
        }

        Map<Integer, Integer> map = new HashMap();
        System.out.println("map isEmpty:" + map.isEmpty());
    }
}

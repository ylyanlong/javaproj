package com.yl.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by leon on 2015/10/8.
 */
public class MyMapT3 {
    public static void main(String[] args){
        Map<Integer, Map<Integer, String> > g2class2name = new HashMap<Integer, Map<Integer, String>>();  // can be replaced with <>
        // g2class2name.get(2).put(20, "yan");  // NullPointerException
        Map<Integer, String> tempMap = new HashMap<Integer, String>();
        tempMap.put(20, "yan");
        tempMap.put(21, "long");
        tempMap.put(22, "tom");
        g2class2name.put(2, tempMap);

        Map<Integer, String> tempMap2 = new HashMap<Integer, String>();
        g2class2name.put(3, tempMap2);

        Set<Map.Entry<Integer, Map<Integer, String> > > g2class2nameEntry = g2class2name.entrySet();
        for(Map.Entry<Integer, Map<Integer, String> > entryEle: g2class2nameEntry){
            System.out.println("----------------begin-----------------");
            int key = entryEle.getKey();
            System.out.println("key: " + key);
            System.out.println("value: " + entryEle.getValue() );
            System.out.println("size: " + entryEle.getValue().size() );
            System.out.println("----------------end-----------------");
        }

    }
}

package com.yl.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/2/28.
 */
public class ConcurrentHashMap1 {
    public static void main(String[] args){
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(2, 5);
        map.putIfAbsent(3, 7);
        // int a = map.putIfAbsent(3, 7);
        // System.out.println("a:" + a);
        int b = map.putIfAbsent(2, 6);
        System.out.println("b:" + b);
        Set<Map.Entry<Integer, Integer> > entries = map.entrySet();
        for(Map.Entry<Integer, Integer> ele: entries ){
            System.out.println(ele.getKey() + " : " + ele.getValue());
        }

        int c = Integer.parseInt(null);
    }
}

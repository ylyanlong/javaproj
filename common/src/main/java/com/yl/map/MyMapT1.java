package com.yl.map;

import java.util.*;

/**
 * Created by leon on 2015/9/11.
 */
public class MyMapT1 {
    public static void main(String[] args){
        Map<String, Integer> hashMap = new HashMap<String, Integer>();  // why not int
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        hashMap.put("Cook", 30);
        System.out.println("hashMap:" + hashMap);
        System.out.println("key: yan, value: " + hashMap.get("yan"));

        Set<String> keys = hashMap.keySet();
        System.out.println("keys: " + keys);
        for(String ele: keys){
            if(ele.equals("Cook")){
                // hashMap.put(ele, 45);
                hashMap.put("yan", 25);
            }
        }

        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            if(key.equals("yan")){
                hashMap.put("yan2", 29);
            }
        }

        Collection<Integer> values = hashMap.values();
        System.out.println("values: " + values);

        Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
        System.out.println("treeMap:" + treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("Lew 's age: " + linkedHashMap.get("Lewis").intValue());
        System.out.println("linkedHashMap:" + linkedHashMap);



    }
}

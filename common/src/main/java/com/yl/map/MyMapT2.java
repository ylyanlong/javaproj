package com.yl.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 2015/9/11.
 */
public class MyMapT2 {
    public static void main(String[] args){
        String text = "Good morning. Have a good clas. Have a good visit. Have fun!";
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String[] words = text.split("[ \n\t\r.,;:!?(){]");
        for(String elem: words){
            String key = elem.toLowerCase();
            if(key.length() > 0){
                if(map.get(key) == null){
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key).intValue();  // Unnecessary unboxing
                    value++;
                    map.put(key, value);
                }
            }
        }

        Set<Map.Entry<String, Integer> > entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry: entrySet){
            System.out.println(entry.getValue() + "\t" + entry.getKey() );
        }
    }
}

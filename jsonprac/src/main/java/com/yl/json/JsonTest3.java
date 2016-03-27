package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/20.
 */
public class JsonTest3 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){
        Recom recom = new Recom();

        /*Set<Long> set1 = new HashSet<>();
        set1.add(12L);
        set1.add(15L);
        set1.add(16L);
        set1.add(17L);

        Set<Long> set2 = new HashSet<>();
        set2.add(21L);
        set2.add(22L);
        set2.add(23L);
        set2.add(24L);

        recom.setId("456");
        recom.getRe().put(1, set1);
        recom.getRe().put(2, set2);*/

        objectMapper = new ObjectMapper();
        String rtn = null;

        try {
            rtn = objectMapper.writeValueAsString(recom);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(rtn);

        /*Map<Integer, String> map1 = new HashMap<>();
        map1.put(12, "tom");
        map1.put(23, "lilei");
        map1.put(36, "john");

        String map1_str = null;

        try {
            map1_str = objectMapper.writeValueAsString(map1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(map1_str);*/



    }
}

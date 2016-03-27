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
public class JsonTest2 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){
        Map<Integer, Map<Integer, Set<Integer> > > uid2anchor = new HashMap<>();
        Map<Integer, Set<Integer> > type2anchor = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(15);
        set1.add(16);
        set1.add(17);

        Set<Integer> set2 = new HashSet<>();
        set2.add(21);
        set2.add(22);
        set2.add(23);
        set2.add(24);
        type2anchor.put(1, set1);
        type2anchor.put(2, set2);
        uid2anchor.put(10, type2anchor);

        objectMapper = new ObjectMapper();
        String rtn = null;

        try {
            rtn = objectMapper.writeValueAsString(uid2anchor);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("rtn:" + rtn);
    }

}

package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/20.
 */
public class JsonTest5 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){

        List< Map<Long, Long> > anchors = new ArrayList< Map<Long, Long> >();
        Map<Long, Long> uid2type1 = new HashMap<>();
        uid2type1.put(124L, 4L);
        anchors.add(uid2type1);

        Map<Long, Long> uid2type2 = new HashMap<>();
        uid2type2.put(324L, 24L);
        anchors.add(uid2type2);

        Map<Long, Long> uid2type3 = new HashMap<>();
        uid2type3.put(524L, 34L);
        anchors.add(uid2type3);

        System.out.println("anchors size:" + anchors.size() );

        objectMapper = new ObjectMapper();
        String rtn = null;


        List< Map<Long, Long> > anchors2 = new ArrayList< Map<Long, Long> >();
        try {
            rtn = objectMapper.writeValueAsString(anchors);

            // anchors2 = objectMapper.readValue(rtn, List< Map<Long, Long> >);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(rtn);
    }

}

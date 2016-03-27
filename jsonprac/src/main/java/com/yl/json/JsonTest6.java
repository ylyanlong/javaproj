package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/24.
 */
public class JsonTest6 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){

        // String anchorStr = "";

        Recom3 recom3 = new Recom3();
        recom3.setId("45");

        RecomAnchor recomAnchor1 = new RecomAnchor(23L, 3);
        RecomAnchor recomAnchor2 = new RecomAnchor(25L, 4);
        recom3.getRe().add(recomAnchor1);
        recom3.getRe().add(recomAnchor2);

        //---------------
        objectMapper = new ObjectMapper();
        String rtn = null;

        Recom3 recom31 = new Recom3();

        // List< Map<Long, Long> > anchors2 = new ArrayList< Map<Long, Long> >();
        try {
            rtn = objectMapper.writeValueAsString(recom3);
            System.out.println(rtn);
            try {
                recom31 = objectMapper.readValue(rtn, Recom3.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //--------------

        System.out.println(recom31.toString());
    }

}

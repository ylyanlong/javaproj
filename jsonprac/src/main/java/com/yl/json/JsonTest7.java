package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2016/3/26.
 */
public class JsonTest7 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){

        Recom4 recom4 = new Recom4();
        recom4.setUid(34);
        recom4.getRatios().add(new RecomUserInfo("car", 45, 67, 89));
        recom4.getRatios().add(new RecomUserInfo("sport", 55, 69, 35));

        String rtn = null;

        objectMapper = new ObjectMapper();

        try {
            rtn = objectMapper.writeValueAsString(recom4);
            System.out.println(rtn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

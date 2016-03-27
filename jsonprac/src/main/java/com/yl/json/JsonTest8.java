package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2016/3/26.
 */
public class JsonTest8 {
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){

        RecomAnchorInfo recomAnchorInfo = new RecomAnchorInfo(8679, "car", 0, 56);

        String rtn = null;

        objectMapper = new ObjectMapper();

        try {
            rtn = objectMapper.writeValueAsString(recomAnchorInfo);
            System.out.println(rtn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

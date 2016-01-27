package com.yl.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/1/19.
 */
public class JsonTest1 {
    // private static JsonGenerator jsonGenerator = null;
    private static ObjectMapper objectMapper = null;

    public static void main(String[] args){
        User user = new User(123, "tom", "pwd", 85);

        objectMapper = new ObjectMapper();
        String rtn = null;

        try {
            rtn = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            objectMapper.writeValue(new File("user_1.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(rtn);

        User userGene = null;
        try {
            userGene = objectMapper.readValue(rtn, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("userGene:" + userGene.toString() );

    }
}
